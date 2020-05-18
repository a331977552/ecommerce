//package com.food.config;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public final class RestAuthenticationEntryPoint
//        implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(
//            final HttpServletRequest request,
//            final HttpServletResponse response,
//            final AuthenticationException authException) throws IOException {
//    System.out.println("commence");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
//                "Unauthorized");
//    }
//}
