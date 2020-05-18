package com.food.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer orderId;
    @Column
    private Integer productId;
    @Column
    private String productName;
    @Column
    private String productDesc;
    @Column
    private Integer quantity;
    @Column
    private BigDecimal subTotal;
    @Column
    private BigDecimal uniprice;
    @Column
    private String img;

}
