package com.food.service.impl;

import com.food.entity.Category;
import com.food.entity.Product;
import com.food.entity.vo.CategoryVO;
import com.food.entity.vo.ProductNameVM;
import com.food.entity.vo.ProductVO;
import com.food.exception.UnexpectedException;
import com.food.repository.CategoryRepository;
import com.food.repository.ProductRepository;
import com.food.service.CategoryService;
import com.food.service.ProductService;
import com.food.utils.CRUDUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;



    @Transactional
    @Override
    public ProductVO addProduct(ProductVO productVO) {

        Product save = repository.save(convertToDAO(productVO));
        return convertToVO(save);
    }
    Product convertToDAO(ProductVO vo){
        Product product = new Product();
        BeanUtils.copyProperties(vo,product,"createDate","updateDate");
        List<Category> categoryByIds = categoryRepository.findAllById(vo.getCategoryIds());
        product.setCategories(categoryByIds);
        return product;
    }
    ProductVO convertToVO(Product save){
        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(save,productVO);
        productVO.setCategoryIds(save.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
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
        CRUDUtils.deleteById(repository,id);
    }

    @Override
    public Optional<ProductVO> getProductById(Integer id) {
        return CRUDUtils.findEntityById(repository,id);
    }

    @Override
    public long count(ProductVO example) {

        return 0;
//        return CRUDUtils.count(repository,example);
    }

    @Override
    public List<ProductVO> getProductByIds(List<Integer> ids) {
        List<Product> products = repository.findAllById(ids);
        return getProductVOS(products);
    }

    @Override
    public List<ProductVO> getProductsByCategoryId(Integer id) {
        Optional<CategoryVO> categoryById = categoryService.getCategoryById(id);
        CategoryVO categoryVO = categoryById.orElseThrow(() -> new UnexpectedException("category " + id + " doesn't exist"));
        return categoryVO.getProducts();
    }

    private List<ProductVO> getProductVOS(List<Product> products) {
        List<ProductVO> productVOs=new ArrayList<>(products.size());

        for (Product product : products) {
            ProductVO vo=new ProductVO();
            BeanUtils.copyProperties(product,vo);
            vo.setCategoryIds(product.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
            productVOs.add(vo);
        }
        return productVOs;
    }

    @Override
    public long countProductsByCategoryId(Integer id) {
        Product product=new Product();
        Category category = new Category();
        category.setId(id);
        product.setCategories(Collections.singletonList(category));
        return repository.count(Example.of(product));
    }

    @Override
    public List<ProductVO> getAll() {
        return getProductVOS(repository.findAll());
    }

    @Override
    public Page<ProductVO> getAll(Pageable page) {
        Page<Product> all = repository.findAll(page);
        List<ProductVO> productVOS = getProductVOS(all.getContent());

        return all.map(this::convertToVO);
    }

    @Override
    public List<ProductVO> getAll(ProductVO productVO) {
        Product product = convertToDAO(productVO);
        return getProductVOS(repository.findAll(Example.of(product)));
    }

    @Override
    public List<ProductNameVM> getAllProductNames() {
        return repository.getAllProductNames();
    }
}
