package com.food.service.impl;

import com.food.exception.InvalidIdException;
import com.food.exception.UnexpectedException;
import com.food.mappers.DeliveryAddressMapper;
import com.food.mappers.OrderFormMapper;
import com.food.mappers.OrderItemMapper;
import com.food.model.*;
import com.food.model.constants.OrderConstants;
import com.food.model.vo.*;
import com.food.service.ICustomerService;
import com.food.service.IMerchantService;
import com.food.service.IOrderFormService;
import com.food.service.IProductService;
import com.food.utils.CheckUpdateUtil;
import com.food.utils.EntityUtils;
import com.food.utils.IDUtils;
import com.food.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.food.model.constants.OrderConstants.DINING_METHOD;
import static com.food.model.constants.OrderConstants.PAYMENT_METHODS;

@Service
public class OrderFormServiceImpl implements IOrderFormService {


    private OrderFormMapper orderFormMapper;
    private OrderItemMapper orderItemMapper;
    private DeliveryAddressMapper deliveryAddressMapper;
    private IProductService productService;
    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private ICustomerService customerService;


    public  OrderFormServiceImpl(OrderFormMapper orderFormMapper, OrderItemMapper orderItemMapper, DeliveryAddressMapper deliveryAddressMapper, IProductService productService){
        this.orderFormMapper = orderFormMapper;
        this.orderItemMapper = orderItemMapper;
        this.deliveryAddressMapper = deliveryAddressMapper;
        this.productService = productService;
    }

    OrderItemVO convertToItemVO(OrderItem item){
        OrderItemVO vo=new OrderItemVO();
        BeanUtils.copyProperties(item,vo);
        return vo;
    }


    @Transactional
    @Override
    public OrderResultVO createOrder(UserClientOrderVO vo) {
        if(vo.getOrderItems().size() == 0){
            throw new UnexpectedException("订单商品列表为空！");
        }

        if(!PAYMENT_METHODS.contains(vo.getPaymentMethod()))
        {
            throw new UnexpectedException("无法识别的支付方式！");
        }
        if(!DINING_METHOD.contains(vo.getDiningMethod()))
        {
            throw new UnexpectedException("无法识别的订餐方式！");
        }

        MerchantVO merchant = merchantService.findMerchantById(vo.getMerchant_id());
        CustomerVO existingCustomer = customerService.findUserByPhoneOrId(vo.getCustomer());
        if(existingCustomer == null){
            vo.getCustomer().setId(null);
            vo.getCustomer().setAuto_generated(true);
            existingCustomer = customerService.addUser(vo.getCustomer());
        }
        Integer customerId = existingCustomer.getId();
        DeliveryAddress address =new DeliveryAddress();
        address.setAddress(vo.getAddress());
        address.setName(vo.getCustomer().getName());
        address.setPhone(vo.getCustomer().getPhone());
        address.setUser_id(customerId);
        address.setPostcode(null);
        deliveryAddressMapper.insert(address);
        List<OrderItemVO> orderItems = vo.getOrderItems();
        OrderForm order = new OrderForm();
        order.setBuyer(vo.getCustomer().getName());
        order.setComment(vo.getComment());
        //TODO 加 expire time， 有用户功能的时候
        //        order.setExpired_time(Instant.now().);

        long orderCode = orderFormMapper.selectOrderCode();

        BigDecimal totalPrice =new BigDecimal(0);
        int quantity=0;
        for (OrderItemVO item : orderItems) {
            ProductVO product = productService.getProductById(item.getProduct_id());
            BigDecimal subTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            item.setSub_total(subTotal);
            item.setUniprice(product.getPrice());
            item.setImg(product.getImgs().get(0).getUrl());
            item.setImg(product.getImgs().get(0).getThumbnail_url());
            item.setProduct_desc(product.getDescription());
            item.setProduct_name(product.getName());
            quantity += item.getQuantity();
            totalPrice = totalPrice.add(subTotal);
        }

        String orderNumber = IDUtils.getOrderId(orderCode);
        order.setPayment_method(vo.getPaymentMethod());
        order.setDining_method(vo.getDiningMethod());
        order.setDelivery_address_id(address.getId());
        order.setOrder_code(orderCode+"");
        order.setOrder_number(orderNumber);
        order.setCreate_time(new Date());
        order.setUpdate_time(order.getCreate_time());
        order.setPhone(vo.getCustomer().getPhone());
        order.setStatus(OrderConstants.STATUS_UNPAID);
        order.setUser_id(customerId);
        order.setMerchant_id(merchant.getId());
        order.setTotal_price(totalPrice);
        order.setTotal_count(quantity);
        int result = orderFormMapper.insert(order);
        if(result != 1)
            throw new UnexpectedException("订单创建异常! 10001");
        Integer orderId = order.getId();
        for (OrderItemVO item : orderItems) {
            item.setOrder_id(orderId);
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(item,orderItem);
            int insert = orderItemMapper.insert(orderItem);
            item.setId(orderItem.getId());
            if(insert != 1){
                throw new UnexpectedException("订单创建异常! 10002");
            }
        }


        //

        DeliveryAddressVO addressVO =new DeliveryAddressVO();
        BeanUtils.copyProperties(address,addressVO);

        OrderResultVO orderResultVO = new OrderResultVO();
        BeanUtils.copyProperties(order,orderResultVO);
        orderResultVO.setOrderItems(orderItems);
        orderResultVO.setCustomer(existingCustomer);
        orderResultVO.setAddress(addressVO);
        orderResultVO.setMerchant(merchant);
        return orderResultVO;
    }


    @Override
    public void updateOrderStatus(Integer id, String status,Integer merchantId) {
        if (!OrderConstants.PAYMENT_STATUS.contains(status)){
            throw new IllegalArgumentException("wrong status: "+status);
        }
        OrderForm form = orderFormMapper.selectByPrimaryKey(id);
        OrderForm order = Optional.ofNullable(form).orElseThrow(new InvalidIdException("order id: " + id + " doesn't exist"));
        if (!order.getMerchant_id().equals(merchantId)){
            throw new BadCredentialsException("access denied! code "+ 10000);
        }
        order.setStatus(status);
        order.setUpdate_time(new Date());
        int i = orderFormMapper.updateByPrimaryKey(order);
        CheckUpdateUtil.test(i,"update order "+order.getId()+" failed");
    }





    @Override
    public OrderResultVO findOrderById(Integer id) {
        OrderForm form = orderFormMapper.selectByPrimaryKey(id);
        OrderResultVO orderResultVO =new OrderResultVO();
        BeanUtils.copyProperties(form,orderResultVO);
        //find all corresponding items.
        OrderItemExample oie =new OrderItemExample();
        oie.createCriteria().andOrder_idEqualTo(id);
        List<OrderItemVO> orderItemVOS = orderItemMapper.selectByExample(oie).stream().map(this::convertToItemVO).collect(Collectors.toList());
        orderResultVO.setOrderItems(orderItemVOS);
        //find the address
        DeliveryAddress address = deliveryAddressMapper.selectByPrimaryKey(form.getDelivery_address_id());
        DeliveryAddressVO addressVO =new DeliveryAddressVO();
        BeanUtils.copyProperties(address,addressVO);
        orderResultVO.setAddress(addressVO);
        //find customer
        if(form.getUser_id() != null){
            CustomerVO customerVO = customerService.getUserById(form.getUser_id());
            orderResultVO.setCustomer(customerVO);
        }
        return  orderResultVO;
    }

    @Override
    public List<OrderForm> findOrderByIds(List<Integer> ids) {
        return null;
    }


    @Override
    public List<OrderForm> findAllOrdersByUserId(Integer userId) {
        return null;
    }

    @Override
    public Page<BusinessClientOrderResultVO> findAllOrdersByMerchantId( BusinessClientOrderQueryVO clientExample, Page<BusinessClientOrderResultVO> page) {
        MerchantVO merchant = merchantService.findMerchantById(clientExample.getMerchant_id());
        if(!"available".equals(merchant.getAvailability())){
            throw  new UnexpectedException("current merchant is not available");
        }
        OrderFormExample ofeExample=new OrderFormExample();
        OrderFormExample.Criteria criteria = ofeExample.createCriteria();
        criteria.andMerchant_idEqualTo(merchant.getId());
        if(clientExample.getStart_create_time() !=null && clientExample.getEnd_create_time() !=null){
            criteria.andCreate_timeBetween(clientExample.getStart_create_time(),clientExample.getEnd_create_time());
        }
        if(clientExample.getStart_update_time() !=null && clientExample.getEnd_update_time() !=null){
            criteria.andUpdate_timeBetween(clientExample.getStart_update_time(),clientExample.getEnd_update_time());
        }
        if(StringUtils.hasText(clientExample.getStatus())){
            criteria.andStatusEqualTo(clientExample.getStatus());
        }

        //prevent sql injection
        String orderBy = page.getOrderBy();
        System.out.println(orderBy);
        if(StringUtils.hasText(orderBy) && !EntityUtils.containsFieldWithName(BusinessClientOrderQueryVO.class,orderBy)){
            throw new IllegalAccessError("stop it! "+ orderBy );
        } else {
            page.setOrderBy("update_time");
        }
        page.setBy(StringUtil.isOneOf(page.getBy(), "desc", "asc") ? page.getBy() : "desc");
        ofeExample.setOrderByClause(page.getOrderBy().trim() +" "+ page.getBy().trim());

        if(StringUtils.hasText(clientExample.getBuyer())){
            criteria.andBuyerLike("%"+clientExample.getBuyer().trim()+"%");
        }

         if(StringUtils.hasText(clientExample.getOrder_number())){
            criteria.andOrder_numberLike("%"+clientExample.getOrder_number().trim()+"%");
        }
         if(StringUtils.hasText(clientExample.getDining_method())){
            criteria.andDining_methodEqualTo(clientExample.getDining_method().trim());
        }

        long totalElements = orderFormMapper.countByExample(ofeExample);
        int offset =page.getCurrentPage()*page.getPageSize();
        List<OrderForm> orderForms = orderFormMapper.selectAll(ofeExample,page.getPageSize(),offset);
        List<BusinessClientOrderResultVO> items = orderForms.stream().map(of -> {
            BusinessClientOrderResultVO vo = new BusinessClientOrderResultVO();
            BeanUtils.copyProperties(of, vo);
            return vo;
        }).collect(Collectors.toList());
        return Page.buildResult(page, (int) totalElements, items);
    }

    @Override
    public long count(OrderForm example) {
        return 0;
    }

}
