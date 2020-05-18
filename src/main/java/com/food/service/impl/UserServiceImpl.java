package com.food.service.impl;

import com.food.entity.Customer;
import com.food.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Override
    public Customer addUser(Customer Customer) {
        return null;
    }

    @Override
    public void updateUserSelective(Customer Customer) {

    }

    @Override
    public void updateAllUsers(Iterable<Customer> Users) {

    }

    @Override
    public void updateUser(Customer Customer) {

    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public Optional<Customer> getUserById(Integer id) {
        return Optional.empty();
    }

    @Override
    public long count(Customer example) {
        return 0;
    }

    @Override
    public List<Customer> getUserByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Customer> getAllUser() {
        return null;
    }
}
