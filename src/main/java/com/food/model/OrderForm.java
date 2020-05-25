package com.food.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderForm implements Serializable {
    private Integer id;

    private Date expired_time;

    private String buyer;

    private String comment;

    private Date create_time;

    private String order_code;

    private String order_number;

    private Integer payment_type;

    private String phone;

    private Integer reservation_type;

    private String status;

    private Date takeaway_time;

    private Integer total_count;

    private BigDecimal total_price;

    private Date update_time;

    private Integer user_id;

    private Integer way_of_eating;

    private Integer delivery_address_id;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(Date expired_time) {
        this.expired_time = expired_time;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code == null ? null : order_code.trim();
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number == null ? null : order_number.trim();
    }

    public Integer getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(Integer payment_type) {
        this.payment_type = payment_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getReservation_type() {
        return reservation_type;
    }

    public void setReservation_type(Integer reservation_type) {
        this.reservation_type = reservation_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTakeaway_time() {
        return takeaway_time;
    }

    public void setTakeaway_time(Date takeaway_time) {
        this.takeaway_time = takeaway_time;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getWay_of_eating() {
        return way_of_eating;
    }

    public void setWay_of_eating(Integer way_of_eating) {
        this.way_of_eating = way_of_eating;
    }

    public Integer getDelivery_address_id() {
        return delivery_address_id;
    }

    public void setDelivery_address_id(Integer delivery_address_id) {
        this.delivery_address_id = delivery_address_id;
    }
}