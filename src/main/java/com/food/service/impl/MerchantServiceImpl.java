package com.food.service.impl;

import com.food.exception.UnexpectedException;
import com.food.mappers.MerchantMapper;
import com.food.model.Merchant;
import com.food.model.MerchantExample;
import com.food.model.vo.MerchantVO;
import com.food.service.IMerchantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class MerchantServiceImpl implements IMerchantService {

    private MerchantMapper merchantMapper;

    public MerchantServiceImpl(MerchantMapper merchantMapper) {
        this.merchantMapper = merchantMapper;
    }

    MerchantVO convertToVO(Merchant merchant){
        MerchantVO vo  = new MerchantVO();
        BeanUtils.copyProperties(merchant,vo);
        return vo;
    }
    Merchant convertToDAO(MerchantVO vo){
        Merchant merchant  = new Merchant();
        BeanUtils.copyProperties(vo,merchant);
        return merchant;
    }

    @Override
    public MerchantVO findByUsername(@NotNull(message = "用户名为空！") @NotEmpty(message = "用户名为空！") String username) {
        MerchantExample example =new MerchantExample();
        example.createCriteria().andUsernameEqualTo(username.trim());
        List<Merchant> merchants = merchantMapper.selectByExample(example);
        if(merchants.size()>1)
            throw new UnexpectedException("服务器异常, multiple username occurred");
        Merchant merchant = merchants.stream().findFirst().orElse(null);
        if(merchant == null)
            return null;
        MerchantVO vo = convertToVO(merchant);
        return  vo;
    }

    @Override
    public MerchantVO addMerchant(MerchantVO vo) {
        vo.setId(null);
        Merchant merchant = convertToDAO(vo);
        merchantMapper.insert(merchant);
        vo.setId(merchant.getId());
        return vo;
    }

    @Override
    public void updateMerchant(MerchantVO vo) {
        Merchant merchant = convertToDAO(vo);
        int i = merchantMapper.updateByPrimaryKey(merchant);
        if(i != 0)
            log.warn("merchant" + vo +" doesn't exist");

    }

    @Override
    public void removeMerchant(MerchantVO vo) {

    }

    @Override
    public MerchantVO findMerchantById(Integer id) {



        return  convertToVO(Optional.ofNullable(merchantMapper.selectByPrimaryKey(id)).orElseThrow(()->new UnexpectedException("商户id "+id+" 不存在")));
    }
}
