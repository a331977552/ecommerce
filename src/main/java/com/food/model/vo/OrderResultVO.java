package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date create_time;

    private String order_code;

    private String order_number;

    private String payment_method;

    private String phone;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date takeaway_time;

    private Integer total_count;

    private BigDecimal total_price;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date update_time;

    private Integer user_id;

    private String dining_method;


    private DeliveryAddressVO address;
    private CustomerVO customer;
    private List<OrderItemVO> orderItems;
    private MerchantVO merchant;




}
