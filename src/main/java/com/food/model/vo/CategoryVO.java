package com.food.model.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryVO {
    private Integer id;
    private String title;
    private String description;
    private Integer merchant_id;
    private int priority;
    @NotNull(message="商户不能为空!")
    private MerchantVO merchant;
    private List<ProductVO> products=new ArrayList<>();
}
