package com.food.model;

import java.io.Serializable;

public class Merchant implements Serializable {
    private Integer id;

    private String name;

    private String notice;

    private String status;

    private String address;

    private String availability;

    private String phone;

    private String wechat_payment_code_url;

    private String wechat_url;

    private String alipay_url;

    private String alipay_payment_code_url;

    private String bank_card_number;

    private String bank_card_name;

    private String bank_card_date;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability == null ? null : availability.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechat_payment_code_url() {
        return wechat_payment_code_url;
    }

    public void setWechat_payment_code_url(String wechat_payment_code_url) {
        this.wechat_payment_code_url = wechat_payment_code_url == null ? null : wechat_payment_code_url.trim();
    }

    public String getWechat_url() {
        return wechat_url;
    }

    public void setWechat_url(String wechat_url) {
        this.wechat_url = wechat_url == null ? null : wechat_url.trim();
    }

    public String getAlipay_url() {
        return alipay_url;
    }

    public void setAlipay_url(String alipay_url) {
        this.alipay_url = alipay_url == null ? null : alipay_url.trim();
    }

    public String getAlipay_payment_code_url() {
        return alipay_payment_code_url;
    }

    public void setAlipay_payment_code_url(String alipay_payment_code_url) {
        this.alipay_payment_code_url = alipay_payment_code_url == null ? null : alipay_payment_code_url.trim();
    }

    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number == null ? null : bank_card_number.trim();
    }

    public String getBank_card_name() {
        return bank_card_name;
    }

    public void setBank_card_name(String bank_card_name) {
        this.bank_card_name = bank_card_name == null ? null : bank_card_name.trim();
    }

    public String getBank_card_date() {
        return bank_card_date;
    }

    public void setBank_card_date(String bank_card_date) {
        this.bank_card_date = bank_card_date == null ? null : bank_card_date.trim();
    }
}