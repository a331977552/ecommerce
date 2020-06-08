package com.food.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVO {
    private Integer id;
    private String title;
    private String description;
    private Integer merchant_id;
    private Integer parent_id;
    private int priority;
    private MerchantVO merchant;
    private List<ProductVO> products=new ArrayList<>();
}
