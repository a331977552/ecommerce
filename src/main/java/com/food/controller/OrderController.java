package com.food.controller;


import com.food.model.vo.*;
import com.food.service.IOrderFormService;
import com.food.utils.AuthorizationUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    /*
    {"paymentMethod":"wechat","diningMethod":"eatIn","customerName":"213213213","phoneNumber":"213213213213213","address":"","cartItems":[{"id":177,"quantity":6,"product":{"id":177,"create_date":"2020-05-17T12:06:22.928+0000","description":"小龙虾醉美味10","hot":null,"name":"花雕醉龙虾 (小分)10","price":51,"priceprev1":null,"priceprev2":null,"quantity_remaining":199,"sales_volume":59,"status":"ON_SALE","update_date":"2020-05-17T12:06:22.928+0000","merchant_id":1,"imgs":[{"id":178,"file_name":null,"full_url":null,"size":null,"url":"https://i.picsum.photos/id/10/300/200.jpg"}],"categoryIds":[14,2],"weight":null,"priority":null,"discount":null},"subPrice":306},{"id":191,"quantity":7,"product":{"id":191,"create_date":"2020-05-17T12:06:23.016+0000","description":"17","hot":null,"name":"黄酒布丁17","price":97,"priceprev1":null,"priceprev2":null,"quantity_remaining":250,"sales_volume":687,"status":"ON_SALE","update_date":"2020-05-17T12:06:23.016+0000","merchant_id":1,"imgs":[{"id":192,"file_name":null,"full_url":null,"size":null,"url":"https://i.picsum.photos/id/17/300/200.jpg"}],"categoryIds":[14,15],"weight":null,"priority":null,"discount":null},"subPrice":679}],"totalPrice":985,"merchant_id":1}
     */

    @Value("${product.list.page.size}")
    Integer pageSize;

    private IOrderFormService orderFormService;



    public OrderController(IOrderFormService orderFormService) {
        this.orderFormService = orderFormService;
    }

    @PostMapping("/place")
    public ResponseEntity<OrderResultVO> indexInfo(@RequestBody UserClientOrderVO order) {
        OrderResultVO order1 = orderFormService.createOrder(order);
        return ResponseEntity.ok(order1);
    }

    /**
     *
     * @param example
     * @return
     */
    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/findAllOrdersByMerchant/{page}/{pageSize}")
    public ResponseEntity<Page<BusinessClientOrderResultVO>> findAllOrdersByMerchantId( HttpServletRequest request,
                                                                    @PathVariable(name = "page") Integer page,
                                                                    @PathVariable(name = "pageSize") Integer pageSize,
                                                                    @RequestParam(name = "orderBy",required = false) String order,
                                                                    @RequestParam(name = "by",required = false) String by,
                                                                    @RequestBody(required =false) BusinessClientOrderQueryVO example) {
        Page<BusinessClientOrderResultVO> of = Page.of(page == null ? 0 : page, pageSize == null ? this.pageSize : pageSize, order,by);
        if(example ==null)
            example =new BusinessClientOrderQueryVO();
        Integer merchantId = AuthorizationUtil.getMerchantId(request);
        example.setMerchant_id(merchantId);
        Page<BusinessClientOrderResultVO> result = orderFormService.findAllOrdersByMerchantId(example,of);
        return ResponseEntity.ok(result);
    }


}