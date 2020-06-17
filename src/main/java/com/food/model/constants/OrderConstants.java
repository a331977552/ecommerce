package com.food.model.constants;

import java.util.List;

public class OrderConstants {
    public static final String PAYMENT_METHOD_WECHAT="wechat";
    public static final String PAYMENT_METHOD_CASH_ON_DELIVERY="cashOnDelivery";
    public static final String PAYMENT_METHOD_BANK_CARD="bankCard";
    public static final List<String> PAYMENT_METHODS = List.of(PAYMENT_METHOD_WECHAT, PAYMENT_METHOD_CASH_ON_DELIVERY, PAYMENT_METHOD_BANK_CARD);

    public static final String DINING_METHOD_EAT_IN="eatIn";
    public static final String DINING_METHOD_TAKE_AWAY="takeaway";
    public static final List<String> DINING_METHOD = List.of(DINING_METHOD_EAT_IN, DINING_METHOD_TAKE_AWAY);


    public static final String STATUS_UNPAID="UNPAID";
    public static final String STATUS_PAID="PAID";
    public static final String STATUS_SHIPPED="SHIPPED";
    public static final String STATUS_COMPLETE="COMPLETE";
    public static final String STATUS_CLOSED="CLOSED";
    public static final String STATUS_REFUND="REFUND";
    public static final String STATUS_CANCEL="CANCEL";
    public static final List<String> PAYMENT_STATUS = List.of(STATUS_UNPAID, STATUS_PAID, STATUS_SHIPPED,STATUS_COMPLETE,STATUS_CLOSED,STATUS_REFUND,STATUS_CANCEL);



}
