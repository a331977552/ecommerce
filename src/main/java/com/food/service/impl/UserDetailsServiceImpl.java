package com.food.service.impl;

import com.food.model.vo.MerchantVO;
import com.food.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    IMerchantService merchantService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MerchantVO byUsername = merchantService.findByUsername(username);
        return byUsername;
    }
}
