package com.food.model;

import java.io.Serializable;

public class ProductImgs implements Serializable {
    private Integer product_id;

    private Integer imgs_id;

    private static final long serialVersionUID = 1L;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getImgs_id() {
        return imgs_id;
    }

    public void setImgs_id(Integer imgs_id) {
        this.imgs_id = imgs_id;
    }
}