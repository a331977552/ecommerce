package com.food.service;


import com.food.model.OrderForm;
import com.food.model.vo.*;

import java.util.List;
import java.util.Optional;

public interface IOrderFormService {
    OrderResultVO createOrder(UserClientOrderVO orderForm);
    void updateOrderSelective(OrderForm orderForm);
    void updateAllOrders(Iterable<OrderForm> orderForms);
    void updateOrder(OrderForm orderForm);
    void deleteOrderById(Integer id);
    Optional<OrderForm> findOrderById(Integer id);
    long count(OrderForm example);
    List<OrderForm> findOrderByIds(List<Integer> ids);
    List<OrderForm> findAllOrder();
    List<OrderForm> findAllOrdersByUserId(Integer userId);
    Page<BusinessClientOrderResultVO> findAllOrdersByMerchantId(BusinessClientOrderQueryVO example, Page<BusinessClientOrderResultVO> page);
}
