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

    private String wechatPaymentCodeUrl;

    private String wechatUrl;

    private String alipayUrl;

    private String alipayPaymentCodeUrl;

    private String bankCardNumber;

    private String bankCardName;

    private String bankCardDate;

    private String username;

    private String password;

    private String role;

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

    public String getWechatPaymentCodeUrl() {
        return wechatPaymentCodeUrl;
    }

    public void setWechatPaymentCodeUrl(String wechatPaymentCodeUrl) {
        this.wechatPaymentCodeUrl = wechatPaymentCodeUrl == null ? null : wechatPaymentCodeUrl.trim();
    }

    public String getWechatUrl() {
        return wechatUrl;
    }

    public void setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl == null ? null : wechatUrl.trim();
    }

    public String getAlipayUrl() {
        return alipayUrl;
    }

    public void setAlipayUrl(String alipayUrl) {
        this.alipayUrl = alipayUrl == null ? null : alipayUrl.trim();
    }

    public String getAlipayPaymentCodeUrl() {
        return alipayPaymentCodeUrl;
    }

    public void setAlipayPaymentCodeUrl(String alipayPaymentCodeUrl) {
        this.alipayPaymentCodeUrl = alipayPaymentCodeUrl == null ? null : alipayPaymentCodeUrl.trim();
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName == null ? null : bankCardName.trim();
    }

    public String getBankCardDate() {
        return bankCardDate;
    }

    public void setBankCardDate(String bankCardDate) {
        this.bankCardDate = bankCardDate == null ? null : bankCardDate.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}