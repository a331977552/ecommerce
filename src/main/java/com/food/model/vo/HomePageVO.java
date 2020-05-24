package com.food.entity.vo;

import com.food.entity.Merchant;
import lombok.Data;

import java.util.List;

@Data
public class HomePageVO {


    private List<CategoryVO> categories;
    private MerchantVO merchant;

}
