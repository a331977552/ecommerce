package com.food.service;

import com.food.entity.vo.CategoryVO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    CategoryVO addCategory(CategoryVO categoryVO);
    void updateCategorySelective(CategoryVO categoryVO);
    void updateAllCategories(Iterable<CategoryVO> categories);
    void updateCategory(CategoryVO CategoryVO);
    void deleteCategoryById(Integer id);
    Optional<CategoryVO> getCategoryById(Integer id);
    long count(CategoryVO example);
    List<CategoryVO> getCategoryByIds(List<Integer> ids);
    List<CategoryVO> getAll();
    List<CategoryVO> getAll(CategoryVO example);
    List<CategoryVO> getAllWithAllProducts();

}
