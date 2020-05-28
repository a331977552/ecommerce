package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MerchantVO {
    private Integer id;

    private String name;

    private String notice;

    private String status;

    private String address;

    private String availability;

}
