package com.food.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductSnapshot implements Serializable {
    private Integer id;

    private Date create_date;

    private String description;

    private String hot;

    private String name;

    private BigDecimal price;

    private BigDecimal priceprev1;

    private BigDecimal priceprev2;

    private Integer quantity_remaining;

    private Integer sales_volume;

    private String status;

    private Date update_date;

    private Integer merchant_id;

    private Integer weight;

    private Integer priority;

    private Integer discount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot == null ? null : hot.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceprev1() {
        return priceprev1;
    }

    public void setPriceprev1(BigDecimal priceprev1) {
        this.priceprev1 = priceprev1;
    }

    public BigDecimal getPriceprev2() {
        return priceprev2;
    }

    public void setPriceprev2(BigDecimal priceprev2) {
        this.priceprev2 = priceprev2;
    }

    public Integer getQuantity_remaining() {
        return quantity_remaining;
    }

    public void setQuantity_remaining(Integer quantity_remaining) {
        this.quantity_remaining = quantity_remaining;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(Integer merchant_id) {
        this.merchant_id = merchant_id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}