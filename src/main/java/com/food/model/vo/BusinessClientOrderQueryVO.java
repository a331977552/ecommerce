package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class BusinessClientOrderQueryVO {
    private Integer id;

    private String buyer;

    private String comment;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date start_create_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date end_create_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date start_update_time;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date end_update_time;
    private Date update_time;
    private Date create_time;

    private String order_code;
    private String order_number;
    private String payment_method;
    private String phone;
    private String status;
    private Integer total_count;
    private BigDecimal total_price;
    private Integer user_id;
    private String dining_method;
    private CustomerVO customer;
    private Integer merchant_id;



}
