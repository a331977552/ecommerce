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

    private String url;

    private String thumbnail_url;

    private Float thumbnail_width;

    private Float thumbnail_height;

    private Float width;

    private Float height;
    private static final long serialVersionUID = 1L;

}