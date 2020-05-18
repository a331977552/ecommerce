package com.food.model;

import java.io.Serializable;

public class CategoryProduct implements Serializable {
    private Integer product_id;

    private Integer category_id;

    private static final long serialVersionUID = 1L;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}