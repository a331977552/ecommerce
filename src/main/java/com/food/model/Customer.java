package com.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private Integer id;

    private String avatar;

    private Date date_of_birth;

    private String name;

    private String phone;

    private String sex;

    private String wxid;

    private Boolean auto_generated;

    private static final long serialVersionUID = 1L;


}