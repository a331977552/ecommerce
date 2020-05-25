package com.food.mappers;

import com.food.model.ProductSnapshot;
import com.food.model.ProductSnapshotExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductSnapshotMapper {
    long countByExample(ProductSnapshotExample example);

    int deleteByExample(ProductSnapshotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSnapshot record);

    int insertSelective(ProductSnapshot record);

    List<ProductSnapshot> selectByExample(ProductSnapshotExample example);

    ProductSnapshot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSnapshot record, @Param("example") ProductSnapshotExample example);

    int updateByExample(@Param("record") ProductSnapshot record, @Param("example") ProductSnapshotExample example);

    int updateByPrimaryKeySelective(ProductSnapshot record);

    int updateByPrimaryKey(ProductSnapshot record);
}