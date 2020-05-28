package com.food.service.impl;

import com.food.exception.UnexpectedException;
import com.food.mappers.CategoryProductMapper;
import com.food.mappers.ProductImgMapper;
import com.food.mappers.ProductMapper;
import com.food.model.*;
import com.food.model.vo.ImgVO;
import com.food.model.vo.ProductNameVM;
import com.food.model.vo.ProductVO;
import com.food.service.ICategoryService;
import com.food.service.IImgService;
import com.food.service.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        List<ImgVO> imgs = productVO.getImgs();
        //insert img
        List<ImgVO> imgsWithId= imgs.stream().map(vo-> imgService.addImg(vo)).collect(Collectors.toList());
        //add mapping for img and product
        imgsWithId.forEach(vo->productImgsMapper.insert(new ProductImg(product.getId(),vo.getId())));

        return convertToVO(product,categoryIds,imgsWithId);
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

//        repository.saveAll(products);
    }

    @Override
    public void updateProduct(ProductVO product) {

//        CRUDUtils.updateSelectively(repository,product);
    }

    @Override
    public void deleteProductById(Integer id) {
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
        return products.stream().map(product -> {
            CategoryProductExample example1 = new CategoryProductExample();
            example1.createCriteria().andProduct_idEqualTo(product.getId());
            List<CategoryProduct> categoryProducts = categoryProductMapper.selectByExample(example1);
            return convertToVO(product, categoryProducts.stream().map(CategoryProduct::getCategory_id).collect(Collectors.toList()), imgService.findImgsByProductId(product.getId()));
        }).collect(Collectors.toList());
    }

    //TODO pageable
    @Override
    public Page<ProductVO> getAll(Pageable page) {
//        Page<Product> all = repository.findAll(page);
//        List<ProductVO> productVOS = getProductVOS(all.getContent());

        return  null;
//        return all.map(this::convertToVO);
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
