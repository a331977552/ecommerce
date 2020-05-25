package com.food.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerVO {
    private Integer id;

    private String avatar;

    private Date date_of_birth;

    private String name;

    private String phone;

    private String sex;

    private String wxid;
}
