package com.food.service.impl;

import com.food.exception.UnexpectedException;
import com.food.mappers.CustomerMapper;
import com.food.model.Customer;
import com.food.model.CustomerExample;
import com.food.model.vo.CustomerVO;
import com.food.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {


    private CustomerMapper mapper;

    public CustomerServiceImpl(CustomerMapper mapper) {
        this.mapper = mapper;
    }

    CustomerVO  convertToVo(Customer customer){
        if(customer == null )
            return  null;
        CustomerVO customerVO=new CustomerVO();
        BeanUtils.copyProperties(customer,customerVO);
        return  customerVO;
    }

    Customer  convertToDAO(CustomerVO vo){
        Customer customer=new Customer();
        BeanUtils.copyProperties(vo,customer);
        return  customer;
    }
    @Override
    public CustomerVO addUser(CustomerVO vo) {
        Customer customer = convertToDAO(vo);
        mapper.insert(customer);
        vo.setId(customer.getId());
        return vo;
    }

    @Override
    public void updateUserSelective(CustomerVO Customer) {

    }

    @Override
    public void updateAllUsers(Iterable<CustomerVO> Users) {

    }

    @Override
    public void updateUser(CustomerVO Customer) {

    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public CustomerVO getUserById(Integer id) {
        return convertToVo( mapper.selectByPrimaryKey(id));
    }

    @Override
    public long count(CustomerVO vo) {

        CustomerExample example=new CustomerExample();

        return mapper.countByExample(example);
    }

    @Override
    public List<CustomerVO> getUserByIds(List<Integer> ids) {
        return  ids.stream().map(id -> mapper.selectByPrimaryKey(id)).collect(Collectors.toList()).stream().map(this::convertToVo).collect(Collectors.toList());
    }

    @Override
    public List<CustomerVO> getAllUser() {
        return null;
    }

    @Override
    public CustomerVO findUserByPhoneOrId(CustomerVO vo) {
        if(vo.getId() == null  && vo.getPhone() == null)
            return  null;
        CustomerExample example =new CustomerExample();

        if(vo.getId()!=null){
            example.createCriteria().andIdEqualTo(vo.getId());
        }

        if(vo.getPhone()!=null){
            example.createCriteria().andPhoneEqualTo(vo.getPhone().trim());
        }
        List<Customer> customers = mapper.selectByExample(example);
        if(customers.size()>1)
            throw new UnexpectedException("duplicate customers");
        Customer customer = customers.stream().findFirst().orElse(null);
        return convertToVo(customer);
    }



    @Override
    public CustomerVO loadUserByUsername(@NotNull(message = "用户名为空！") @NotEmpty(message = "用户名为空！")String username) throws UsernameNotFoundException {
        CustomerExample example =new CustomerExample();
        System.out.println("loadUserByUsername -----------");
       /* example.createCriteria().andUsernameEqualTo(username.trim());
        List<Merchant> merchants = mapper.selectByExample(example);
        if(merchants.size()>1)
            throw new UnexpectedException("服务器异常, multiple username occurred");
        Merchant merchant = merchants.stream().findFirst().orElse(null);
        if(merchant == null)
            return null;
        MerchantVO vo = convertToVO(merchant);*/
        return  null;
    }
}
