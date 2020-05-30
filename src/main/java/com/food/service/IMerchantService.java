package com.food.service;

import com.food.model.vo.MerchantVO;

public interface IMerchantService {


     MerchantVO findByUsername(String username);
     MerchantVO addMerchant(MerchantVO vo);
     void updateMerchant(MerchantVO vo);
     void removeMerchant(MerchantVO vo);
     MerchantVO findMerchantById(Integer id);

}
