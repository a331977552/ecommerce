package com.food.entity.vo;

import com.food.entity.Customer;
import com.food.entity.OrderForm;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class UserVM {

    private Customer customer;
    private Set<OrderForm> orders;


}
