package com.food.utils;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationUtil {

    public static Integer getMerchantId( HttpServletRequest request){
        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        return JWTUtil.getID(token);
    }
}
