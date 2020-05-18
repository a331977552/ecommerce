package com.food.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@ToString
public class OrderForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String  buyer;
    @Column
    private String  phone;

    @Column
    private String  comment;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    private Date  updateTime;

    @Column
    private String  orderNumber;

    @Enumerated(EnumType.STRING)
    private Status  status;

    public enum Status{
        CONFIRMED,
        PAID,
        UNPAID,
        CANCELED,
        FINISHED,

    }

    @Column
    private BigDecimal totalPrice;
    @Column
    private WAY_OF_EATING wayOfEating;
    public enum WAY_OF_EATING {
        TAKE_AWAY,
        EAT_IN,
    }

    @Column
    private ReservationType  reservationType;
    public enum ReservationType {
        NOW,
        LATER,
    }

    @Column
    private Date  takeawayTime;
    @Column
    private Date  ExpiredTime;
    @Column
    private String orderCode;
    @Column
    private PaymentType  paymentType;

    public enum PaymentType {
        WECHAT,
        ALIPAY,
    }
    @Column
    private Integer  userId;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "orderId")
    private Set<OrderItem> orderItems;

    @Column
    private Integer totalCount;

}
