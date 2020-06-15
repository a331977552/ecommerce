package com.food.model.vo;

import lombok.Data;

@Data
public class ImgVO {
    private Integer id;

    private String file_name;

    private String full_url;

    private String url;

    private String thumbnail_url;

    private Float thumbnail_width;

    private Float thumbnail_height;

    private Float width;

    private Float height;

}
