package com.food.repository;

import com.food.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFormRepository extends JpaRepository<OrderForm, Integer> {

}
