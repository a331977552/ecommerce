package com.food.interceptor;

import com.food.utils.JWTUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MerchantIdInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        Integer id = JWTUtil.getID(token);
        request.setAttribute("merchantId",id);

        return false;
    }
}
