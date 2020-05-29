package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MerchantVO {
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

}
