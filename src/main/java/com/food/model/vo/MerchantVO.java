package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String role;

    public void setAuthorities() {
        this.authorities = Set.of(new SimpleGrantedAuthority(getRole()));
    }
    @JsonIgnore
    private Set<SimpleGrantedAuthority> authorities;
    public MerchantVO(){

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
