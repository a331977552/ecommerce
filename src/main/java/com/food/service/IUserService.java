package com.food.service;

import com.food.model.Customer;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Customer addUser(Customer Customer);
    void updateUserSelective(Customer Customer);
    void updateAllUsers(Iterable<Customer> Users);
    void updateUser(Customer Customer);
    void deleteUserById(Integer id);
    Optional<Customer> getUserById(Integer id);
    long count(Customer example);
    List<Customer> getUserByIds(List<Integer> ids);
    List<Customer> getAllUser();


}
