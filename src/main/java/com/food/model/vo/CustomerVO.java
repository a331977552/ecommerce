package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CustomerVO {
    private Integer id;

    private String avatar;

    private Date date_of_birth;

    private String name;

    private String phone;

    private String sex;

    private String wxid;
    @JsonIgnore
    private Boolean auto_generated;
}
