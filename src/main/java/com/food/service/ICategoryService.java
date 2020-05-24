package com.food.service;


import com.food.model.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    CategoryVO addCategory(CategoryVO categoryVO);
    void updateCategorySelective(CategoryVO categoryVO);
    void updateAllCategories(Iterable<CategoryVO> categories);
    void updateCategory(CategoryVO CategoryVO);
    void deleteCategoryById(Integer id);
    CategoryVO getCategoryById(Integer id);
    long count(CategoryVO example);
    List<CategoryVO> getCategoryByIds(List<Integer> ids);
    List<CategoryVO> getAll();
    List<CategoryVO> getAll(CategoryVO example);

}
