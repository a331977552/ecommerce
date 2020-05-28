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
public class Img implements Serializable {
    private Integer id;

    private String file_name;

    private String full_url;

    private String size;

    private String url;

    private static final long serialVersionUID = 1L;

}