package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class OrderVO {
    @NotNull(message = "支付方法不能为空！")
    private String paymentMethod;

    private String address;
    @NotNull(message = "订餐方式不能为空！")
    private String diningMethod;
    @NotNull
    private CustomerVO customer;
    @NotNull(message = "商户ID为空！")
    private Integer merchant_id;
    private String comment;
    private BigDecimal totalPrice;
    private List<OrderItemVO> orderItems;
}
