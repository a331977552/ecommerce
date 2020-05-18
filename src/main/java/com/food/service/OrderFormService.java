package com.food.service;

import com.food.entity.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrderFormService {
    OrderForm createOrder(OrderForm orderForm);
    void updateOrderSelective(OrderForm orderForm);
    void updateAllOrders(Iterable<OrderForm> orderForms);
    void updateOrder(OrderForm orderForm);
    void deleteOrderById(Integer id);
    Optional<OrderForm> getOrderById(Integer id);
    long count(OrderForm example);
    List<OrderForm> getOrderByIds(List<Integer> ids);
    List<OrderForm> getAllOrder();
    List<OrderForm> getAllOrderByUserId(Integer userId);


}
