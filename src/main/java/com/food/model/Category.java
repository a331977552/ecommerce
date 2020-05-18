package com.food.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Category implements Serializable {

    private Integer id;

    private String description;

    private Integer priority;

    private String title;

    private Integer merchant_id;

    private static final long serialVersionUID = 1L;

}