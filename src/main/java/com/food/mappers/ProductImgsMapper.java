package com.food.mappers;

import com.food.model.ProductImgs;
import com.food.model.ProductImgsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductImgsMapper {
    long countByExample(ProductImgsExample example);

    int deleteByExample(ProductImgsExample example);

    int insert(ProductImgs record);

    int insertSelective(ProductImgs record);

    List<ProductImgs> selectByExample(ProductImgsExample example);

    int updateByExampleSelective(@Param("record") ProductImgs record, @Param("example") ProductImgsExample example);

    int updateByExample(@Param("record") ProductImgs record, @Param("example") ProductImgsExample example);
}