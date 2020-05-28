package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class OrderResultVO {

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

    private CustomerVO customer;
    private List<OrderItemVO> orderItems;




}
