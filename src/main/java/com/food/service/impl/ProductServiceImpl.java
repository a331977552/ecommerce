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
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
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
        List<ImgVO> imgs = productVO.getImgs();
        //insert img

        //add mapping for img and product
        imgs.forEach(vo->productImgsMapper.insert(new ProductImg(product.getId(),vo.getId())));

        return convertToVO(product,categoryIds,imgs);
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
        int i = mapper.updateByPrimaryKey(convertToDAO(example));
        if(i!=0){
            Integer productId = example.getId();
            //delete product
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
        ProductExample example1 = new ProductExample();
        ProductExample.Criteria criteria = example1.createCriteria();

        if(example.getMerchant_id()!=null)
        {
            criteria.andMerchant_idEqualTo(example.getMerchant_id());
        }
        if(!StringUtils.isEmpty(example.getStatus())){
            criteria.andStatusEqualTo(example.getStatus().trim());
        }

        Field[] fields = ProductVO.class.getDeclaredFields();
        //prevent sql injection
        if(page.getOrderBy()!=null  && !page.getOrderBy().trim().equals("")){
            String orderBy = page.getOrderBy().trim();
            boolean foundField = List.of(fields).stream().anyMatch(field -> orderBy.equals(field.getName()));
            if(!foundField)
            {
                throw new UnexpectedException("stop it!");
            }
        } else{
            page.setOrderBy("priority");
        }

        if(page.getBy()== null || !page.getBy().equals("desc") ||!page.getBy().equals("asc")){
            page.setBy("asc");
        }
        example1.setOrderByClause(page.getOrderBy() +" "+ page.getBy());
        if(!StringUtils.isEmpty(example.getName())){
            criteria.andNameLike("%"+example.getName()+"%");
        }
        long l = mapper.countByExample(example1);
        page.setTotalElements((int) l);
        page.setTotalPages((int) ((l+page.getPageSize()-1)/page.getPageSize()));

        page.setCurrentPage(page.getCurrentPage()<= 0 ?0:page.getCurrentPage()>=page.getTotalPages()? page.getTotalPages()-1:page.getCurrentPage());

        page.setOffset(page.getCurrentPage()*page.getPageSize());
        page.setFirst(page.getCurrentPage() == 0);
        page.setLast( page.getCurrentPage()+1 == page.getTotalPages());
        List<Product> products = mapper.selectAll(example1,page);
        page.setEmpty(products.size() == 0);
        //plus one , current page in view layer should start from 1
        List<ProductVO> collect1 = products.stream().map(this::setImgsAndCategory).collect(Collectors.toList());
        page.setItems(collect1);
        return page;
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
