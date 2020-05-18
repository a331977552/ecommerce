package com.food.mappers;

import com.food.model.CategoryProduct;
import com.food.model.CategoryProductExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryProductMapper {
    long countByExample(CategoryProductExample example);

    int deleteByExample(CategoryProductExample example);

    int insert(CategoryProduct record);

    int insertSelective(CategoryProduct record);

    List<CategoryProduct> selectByExample(CategoryProductExample example);

    int updateByExampleSelective(@Param("record") CategoryProduct record, @Param("example") CategoryProductExample example);

    int updateByExample(@Param("record") CategoryProduct record, @Param("example") CategoryProductExample example);
}