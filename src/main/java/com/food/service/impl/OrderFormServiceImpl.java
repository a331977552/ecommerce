package com.food.service.impl;

import com.food.model.OrderForm;
import com.food.service.IOrderFormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderFormServiceImpl implements IOrderFormService {


    @Override
    public OrderForm createOrder(OrderForm orderForm) {
        return null;
    }

    @Override
    public void updateOrderSelective(OrderForm orderForm) {

    }

    @Override
    public void updateAllOrders(Iterable<OrderForm> orderForms) {

    }

    @Override
    public void updateOrder(OrderForm orderForm) {

    }

    @Override
    public void deleteOrderById(Integer id) {

    }

    @Override
    public Optional<OrderForm> getOrderById(Integer id) {
        return Optional.empty();
    }

    @Override
    public long count(OrderForm example) {
        return 0;
    }

    @Override
    public List<OrderForm> getOrderByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<OrderForm> getAllOrder() {
        return null;
    }

    @Override
    public List<OrderForm> getAllOrderByUserId(Integer userId) {
        return null;
    }
}
