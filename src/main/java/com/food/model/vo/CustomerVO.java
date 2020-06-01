package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@ToString
public class CustomerVO implements UserDetails {
    private Integer id;

    private String avatar;

    private Date date_of_birth;

    private String name;

    private String phone;
    private String password;
    private String username;

    private String sex;

    private String wxid;
    private String role;
    @JsonIgnore
    private Boolean auto_generated;

    private Set<SimpleGrantedAuthority> authorities;
    public CustomerVO(){

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
