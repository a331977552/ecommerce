package com.food.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderVO {
    private String paymentMethod;
    private String address;
    private String diningMethod;
    private CustomerVO customer;
    private Integer merchant_id;
    private BigDecimal totalPrice;
    private List<OrderItemVO> orderItems;

}
