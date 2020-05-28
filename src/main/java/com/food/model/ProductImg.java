package com.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImg implements Serializable {
    private Integer product_id;

    private Integer img_id;

    private static final long serialVersionUID = 1L;
}