package com.food.entity.vo;

import com.food.entity.Merchant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVO {
    private Integer id;
    private String title;
    private String description;
    private int priority;
    private Merchant merchant;
    private List<ProductVO> products=new ArrayList<>();
}
