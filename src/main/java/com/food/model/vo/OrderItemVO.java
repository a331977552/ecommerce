package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class OrderItemVO {

    private Integer id;
    private Integer product_id;
    private Integer order_id;
    private Integer quantity;
    private String img;
    private String product_desc;
    private String product_name;
    private BigDecimal sub_total;
    private BigDecimal uniprice;


}
