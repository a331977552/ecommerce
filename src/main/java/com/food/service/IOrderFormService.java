package com.food.service;


import com.food.model.OrderForm;
import com.food.model.vo.OrderResultVO;
import com.food.model.vo.OrderVO;

import java.util.List;
import java.util.Optional;

public interface IOrderFormService {
    OrderResultVO createOrder(OrderVO orderForm);
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
