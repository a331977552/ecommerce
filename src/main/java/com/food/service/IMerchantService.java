package com.food.service;

import com.food.model.vo.MerchantVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IMerchantService extends UserDetailsService {


     MerchantVO findByUsername(String username);
     MerchantVO addMerchant(MerchantVO vo);
     void updateMerchant(MerchantVO vo);
     void removeMerchant(MerchantVO vo);
     MerchantVO findMerchantById(Integer id);

}
