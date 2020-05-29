package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeliveryAddressVO {

    private Integer id;

    private String address;

    private String phone;

    private String name;

    private String postcode;

    private Integer user_id;

}
