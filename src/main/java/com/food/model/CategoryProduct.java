package com.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProduct implements Serializable {
    private Integer product_id;

    private Integer category_id;

    private static final long serialVersionUID = 1L;

}