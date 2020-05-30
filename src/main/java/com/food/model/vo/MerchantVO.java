package com.food.model.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@ToString
public class MerchantVO  implements UserDetails {
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

    private String username;

    private String password;

    private String role;

    private Set<SimpleGrantedAuthority> authorities;
    public MerchantVO(){

        authorities = Set.of(new SimpleGrantedAuthority(getRole()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }

}
