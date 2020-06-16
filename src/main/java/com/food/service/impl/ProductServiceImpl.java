package com.food.service.impl;

import com.food.exception.UnexpectedException;
import com.food.mappers.CategoryProductMapper;
import com.food.mappers.ProductImgMapper;
import com.food.mappers.ProductMapper;
import com.food.model.*;
import com.food.model.vo.*;
import com.food.service.ICategoryService;
import com.food.service.IImgService;
import com.food.service.IProductService;
import com.food.utils.EntityUtils;
import com.food.utils.Lists;
import com.food.utils.StringUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements IProductService {



    @Autowired
    private ICategoryService categoryService;
    private ProductMapper mapper;
    private CategoryProductMapper categoryProductMapper;
    private ProductImgMapper productImgsMapper;

    @Autowired
    private IImgService imgService;

    public ProductServiceImpl(ProductMapper mapper, CategoryProductMapper categoryProductMapper,ProductImgMapper productImgsMapper) {
        this.mapper = mapper;
        this.categoryProductMapper = categoryProductMapper;
        this.productImgsMapper = productImgsMapper;
    }

    @Transactional
    @Override
    public ProductVO addProduct(ProductVO productVO) {
        Product product = convertToDAO(productVO);
        product.setCreate_date(new Date());
        product.setUpdate_date(product.getCreate_date());
        mapper.insert(product);
        List<Integer> categoryIds = productVO.getCategoryIds();
        //map product into  categories
        categoryIds.forEach(id-> categoryProductMapper.insert(new CategoryProduct(product.getId(),id)));

        productVO.getImgs().forEach(vo->productImgsMapper.insert(new ProductImg(product.getId(),vo.getId())));
        List<ImgVO> imgsByProductId = imgService.findImgsByProductId(product.getId());

        return convertToVO(product,categoryIds,imgsByProductId);
    }
    Product convertToDAO(ProductVO vo){
        Product product = new Product();
        BeanUtils.copyProperties(vo,product);
        return product;
    }
    ProductVO convertToVO(Product save,List<Integer> categoriesId,List<ImgVO> imgVOS){
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(save,productVO);
        productVO.setCategoryIds(categoriesId);
        productVO.setImgs(imgVOS);
        List<CategoryVO> categoryByIds = categoryService.getCategoryByIds(categoriesId);
        List<ProductVO.InnerCategoryVO> collect = categoryByIds.stream().map(ci -> new ProductVO.InnerCategoryVO(ci.getId(), ci.getTitle())).collect(Collectors.toList());
        productVO.setCategories(collect);

        return productVO;
    }

    @Override
    public void updateProductSelective(ProductVO product) {

    }

    @Override
    public void updateAllProducts(Iterable<ProductVO> products) {

    }

    @Transactional
    @Override
    public void updateProduct(ProductVO example) {
        example.setUpdate_date(new Date());
        int i = mapper.updateByPrimaryKey(convertToDAO(example));
        if(i!=0){
            Integer productId = example.getId();
            //delete product and category connection
            CategoryProductExample cp =new CategoryProductExample();
            cp.createCriteria().andProduct_idEqualTo(productId);
            ProductImgExample pi= new ProductImgExample();
            pi.createCriteria().andProduct_idEqualTo(productId);

            categoryProductMapper.deleteByExample(cp);
            example.getCategoryIds().forEach(cateId->categoryProductMapper.insert(new CategoryProduct(productId,cateId)));

            productImgsMapper.deleteByExample(pi);
            example.getImgs().forEach(imgVO ->productImgsMapper.insert(new ProductImg(productId,imgVO.getId())));
        }else {
            throw new UnexpectedException("产品 "+example.getId()+"更新失败! ");
        }
    }

    @Transactional
    @Override
    public void deleteProductById(Integer id) {
        CategoryProductExample example = new CategoryProductExample();
        example.createCriteria().andProduct_idEqualTo(id);
        int i = categoryProductMapper.deleteByExample(example);
        ProductImgExample productImgExample =new ProductImgExample();
        productImgExample.createCriteria().andProduct_idEqualTo(id);
        productImgsMapper.deleteByExample(productImgExample);
        if(i == 0)
            throw new UnexpectedException("cannot delete this product. code "+ 30000);
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductVO getProductById(Integer id) {
        Product product = mapper.selectByPrimaryKey(id);
        if(product == null)
            throw new UnexpectedException("product with id "+id +" doesn't exist");
        //all relevant categoryIds
        CategoryProductExample example=new CategoryProductExample();
        example.createCriteria().andProduct_idEqualTo(id);
        List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(example);
        List<Integer> allCategoryIds = categoryProducts.stream().map(CategoryProduct::getCategory_id).collect(Collectors.toList());
        //all relevant img Ids
        ProductImgExample productImgsExample=new ProductImgExample();
        productImgsExample.createCriteria().andProduct_idEqualTo(id);
        List<ImgVO> imgsByProductId = imgService.findImgsByProductId(id);

        return convertToVO(product,allCategoryIds,imgsByProductId);
    }

    @Override
    public long count(ProductVO example) {

        return mapper.countByExample(new ProductExample());
    }

    @Override
    public List<ProductVO> getProductByIds(List<Integer> ids) {
        return ids.stream().map(this::getProductById).collect(Collectors.toList());
    }

    @Override
    public List<ProductVO> getProductsByCategoryId(Integer id) {
        CategoryProductExample example = new CategoryProductExample();
        example.createCriteria().andCategory_idEqualTo(id);
        List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(example);
        return categoryProducts.stream().map(cp -> this.getProductById(cp.getProduct_id())).collect(Collectors.toList());
    }

    private List<ProductVO> getProductVOS(List<Product> products) {
        List<ProductVO> productVOs=new ArrayList<>(products.size());

        for (Product product : products) {
            ProductVO vo=new ProductVO();
            BeanUtils.copyProperties(product,vo);
           productVOs.add(vo);
        }
        return productVOs;
    }

    @Override
    public long countProductsByCategoryId(Integer id) {
        CategoryProductExample example = new CategoryProductExample();
        example.createCriteria().andCategory_idEqualTo(id);
        List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(example);
        return categoryProducts.size();
    }

    @Override
    public List<ProductVO> getAll() {
        ProductExample example = new ProductExample();
        List<Product> products = mapper.selectByExample(example);
        return products.stream().map(this::setImgsAndCategory).collect(Collectors.toList());
    }

    ProductVO setImgsAndCategory(Product product) {
        CategoryProductExample example1 = new CategoryProductExample();
        example1.createCriteria().andProduct_idEqualTo(product.getId());
        List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(example1);
        List<CategoryVO> collect = categoryProducts.stream().map(cp -> categoryService.getCategoryById(cp.getCategory_id())).collect(Collectors.toList());
        List<ProductVO.InnerCategoryVO> innerCategoryVOS = collect.stream().map(cateVo -> new ProductVO.InnerCategoryVO(cateVo.getId(), cateVo.getTitle())).collect(Collectors.toList());
        ProductVO vo = convertToVO(product, categoryProducts.stream().map(CategoryProduct::getCategory_id).collect(Collectors.toList()), imgService.findImgsByProductId(product.getId()));
        vo.setCategories(innerCategoryVOS);
        return vo;
    }

    @Override
    public Page<ProductVO> getAll(ProductVO example, Page<ProductVO> page) {
        ProductExample peExample = new ProductExample();
        ProductExample.Criteria criteria = peExample.createCriteria();

        if(example.getMerchant_id()!=null)
        {
            criteria.andMerchant_idEqualTo(example.getMerchant_id());
        }
        if(StringUtils.hasText(example.getStatus())){
            criteria.andStatusEqualTo(example.getStatus().trim());
        }
        //prevent sql injection
        String orderBy = page.getOrderBy();
        if(StringUtils.hasText(orderBy) && !EntityUtils.containsFieldWithName(ProductVO.class,orderBy)){
                throw new IllegalAccessError("stop it!");
        } else {
            page.setOrderBy("update_date");
        }
        page.setBy(StringUtil.isOneOf(page.getBy(), "desc", "asc") ? page.getBy() : "desc");
        peExample.setOrderByClause(page.getOrderBy().trim() +" "+ page.getBy().trim());

        if(StringUtils.hasText(example.getName())){
            criteria.andNameLike("%"+example.getName().trim()+"%");
        }
        if(Lists.hasElements(example.getCategoryIds())){
            CategoryProductExample cpe =new CategoryProductExample();
            cpe.createCriteria().andCategory_idIn(example.getCategoryIds());
            List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(cpe);
            if(Lists.hasElements(categoryProducts))
                criteria.andIdIn(categoryProducts.stream().map(CategoryProduct::getProduct_id).collect(Collectors.toList()));
            else {
                return  Page.emptyPage();
            }
        }
        long count = mapper.countByExample(peExample);
        List<Product> products = mapper.selectAll(peExample,page);
        List<ProductVO> items = products.stream().map(this::setImgsAndCategory).collect(Collectors.toList());
        return Page.buildResult(page, (int) count, items);
    }


    //TODO select by example
    @Override
    public List<ProductVO> getAll(ProductVO productVO) {
        return null;
    }

    @Override
    public List<ProductNameVM> getAllProductNames() {
        ProductExample example = new ProductExample();
        return  mapper.selectByExample(example).stream().map(product->new ProductNameVM(product.getId(),product.getName())).collect(Collectors.toList());
    }
}
