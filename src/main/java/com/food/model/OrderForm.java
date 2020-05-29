package com.food.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class OrderForm implements Serializable {
    private Integer id;

    private Date expired_time;

    private String buyer;

    private String comment;

    private Date create_time;

    private String order_code;

    private String order_number;

    private String payment_method;

    private String phone;

    private String status;

    private Date takeaway_time;

    private Integer total_count;

    private BigDecimal total_price;

    private Date update_time;

    private Integer user_id;

    private String dining_method;

    private Integer delivery_address_id;


    private Integer merchant_id;


    private static final long serialVersionUID = 1L;

}