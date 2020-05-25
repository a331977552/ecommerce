package com.food.model.vo;

import com.food.model.Customer;
import com.food.model.OrderForm;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class UserVM {

    private Customer customer;
    private Set<OrderForm> orders;


}
