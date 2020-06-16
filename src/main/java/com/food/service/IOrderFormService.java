package com.food.service;


import com.food.model.OrderForm;
import com.food.model.vo.BusinessClientOrderResultVO;
import com.food.model.vo.OrderResultVO;
import com.food.model.vo.Page;
import com.food.model.vo.UserClientOrderVO;

import java.util.List;
import java.util.Optional;

public interface IOrderFormService {
    OrderResultVO createOrder(UserClientOrderVO orderForm);
    void updateOrderSelective(OrderForm orderForm);
    void updateAllOrders(Iterable<OrderForm> orderForms);
    void updateOrder(OrderForm orderForm);
    void deleteOrderById(Integer id);
    Optional<OrderForm> getOrderById(Integer id);
    long count(OrderForm example);
    List<OrderForm> getOrderByIds(List<Integer> ids);
    List<OrderForm> findAllOrder();
    List<OrderForm> findAllOrdersByUserId(Integer userId);
    Page<BusinessClientOrderResultVO> findAllOrdersByMerchantId(BusinessClientOrderResultVO example, Page<BusinessClientOrderResultVO> page);


}
