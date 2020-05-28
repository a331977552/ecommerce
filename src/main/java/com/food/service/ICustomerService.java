package com.food.service;

import com.food.model.vo.CustomerVO;

import java.util.List;

public interface ICustomerService {

    CustomerVO addUser(CustomerVO Customer);
    void updateUserSelective(CustomerVO Customer);
    void updateAllUsers(Iterable<CustomerVO> Users);
    void updateUser(CustomerVO Customer);
    void deleteUserById(Integer id);
    CustomerVO getUserById(Integer id);
    long count(CustomerVO example);
    List<CustomerVO> getUserByIds(List<Integer> ids);
    List<CustomerVO> getAllUser();

    CustomerVO findUserByPhoneOrId(CustomerVO vo);


}
