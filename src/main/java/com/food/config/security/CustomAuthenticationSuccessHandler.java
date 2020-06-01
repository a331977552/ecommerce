package com.food.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.utils.JWTUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        System.out.println("jwtUser:" + details.toString());

        String role = "";
        GrantedAuthority grantedAuthority = details.getAuthorities().stream().findFirst().orElse(null);

        if(grantedAuthority != null){
            role = grantedAuthority.getAuthority();
        }
        String token = JWTUtil.createToken(details.getUsername(), role);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String tokenStr = JWTUtil.TOKEN_PREFIX + token;
       /* if(details instanceof MerchantVO){
            MerchantVO merchantVO = (MerchantVO) details;
            merchantVO.setAuthorities(null);
            merchantVO.setPassword(null);
        }else  if( details instanceof CustomerVO){
            CustomerVO customerVO = (CustomerVO) details;
            customerVO.setPassword(null);
        }else {
            log.error("unknown user type: "+  details);
        }*/
        response.getWriter().println(objectMapper.writeValueAsString(details));
        response.setHeader("token",tokenStr);
    }
}
