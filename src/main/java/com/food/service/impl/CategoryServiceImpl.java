package com.food.service.impl;

import com.food.mappers.CategoryMapper;
import com.food.entity.Category;
import com.food.entity.Product;
import com.food.entity.vo.CategoryVO;
import com.food.entity.vo.ProductVO;
import com.food.exception.CategoryDeleteException;
import com.food.repository.CategoryRepository;
import com.food.service.CategoryService;
import com.food.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository repository;

    final CategoryMapper mapper;
    @Autowired
    private ProductService productService;

    public CategoryServiceImpl(CategoryMapper mapper) {
        this.mapper = mapper;
    }


    CategoryVO convertToVO(Category category){
        CategoryVO categoryVO=new CategoryVO();
        BeanUtils.copyProperties(category,categoryVO,"products");
        List<ProductVO> productVOS=new ArrayList<>(category.getProducts().size());
        for (Product pro : category.getProducts()) {
            ProductVO vo=new ProductVO();
            BeanUtils.copyProperties(pro,vo);
            productVOS.add(vo);
        }
        categoryVO.setProducts(productVOS);
        return categoryVO;
    }

    List<CategoryVO> convertToVOs(List<Category> categories){
        return categories.stream().map(this::convertToVO).collect(Collectors.toList());
    }



    Category convertToDAO(CategoryVO vo){
        Category category=new Category();
        BeanUtils.copyProperties(vo,category,"products");
        return category;
    }

    @Override
    public CategoryVO addCategory(CategoryVO category) {
        com.food.model.Category category1=new com.food.model.Category();
        BeanUtils.copyProperties(category,category1);
        int insert = mapper.insert(category1);
        System.out.println(insert);
        System.out.println(category1);
        return category;
    }

    @Override
    public void updateCategorySelective(CategoryVO CategoryVO) {

    }

    @Override
    public void updateAllCategories(Iterable<CategoryVO> Categories) {

    }

    @Override
    public void updateCategory(CategoryVO category) {
        repository.save(convertToDAO(category));
    }

    @Override
    public void deleteCategoryById(Integer id) {

        long count = productService.countProductsByCategoryId(id);
        if(count>0){
            throw  new CategoryDeleteException("category.delete.have.product");
        }
        repository.deleteById(id);
    }

    @Override
    public Optional<CategoryVO> getCategoryById(Integer id) {

        Optional<Category> one = repository.findById(id);

        return one.map(this::convertToVO);
    }

    @Override
    public long count(CategoryVO example) {

        return repository.count(Example.of(convertToDAO(example)));
    }

    @Override
    public List<CategoryVO> getCategoryByIds(List<Integer> ids) {

        return convertToVOs(repository.findAllById(ids));
    }

    @Override
    public List<CategoryVO> getAll() {
        return convertToVOs(repository.findAll());
    }

    @Override
    public List<CategoryVO> getAll(CategoryVO example) {

        return convertToVOs(repository.findAll(Example.of(convertToDAO(example))));
    }

    @Override
    public List<CategoryVO> getAllWithAllProducts() {
        return  convertToVOs(repository.findAll());
    }
}
