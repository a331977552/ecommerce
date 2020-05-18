package com.food.repository;

import com.food.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {

}