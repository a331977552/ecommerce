package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserClientHomeVO {

    List<CategoryVO>  categories;
    MerchantVO merchant;

}
