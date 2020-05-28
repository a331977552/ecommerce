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
public class Category implements Serializable {
    private Integer id;

    private String description;

    private Integer priority;

    private String title;

    private Integer merchant_id;

    private Integer parent_id;


}