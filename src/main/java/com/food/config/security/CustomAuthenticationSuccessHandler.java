package com.food.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.model.vo.CustomerVO;
import com.food.model.vo.MerchantVO;
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
import java.rmi.UnexpectedException;

@Log4j2
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        String role = "";
        GrantedAuthority grantedAuthority = details.getAuthorities().stream().findFirst().orElse(null);

        if(grantedAuthority != null){
            role = grantedAuthority.getAuthority();
        }
        Integer id = null;
        String key = null;
        if(details instanceof MerchantVO){
            MerchantVO merchantVO = (MerchantVO) details;
            merchantVO.setPassword(null);
            id = merchantVO.getId();
            key = "merchantId";

        }else  if( details instanceof CustomerVO){
            CustomerVO customerVO = (CustomerVO) details;
            customerVO.setPassword(null);
            id = customerVO.getId();
            key = "customerId";
        }else {
            log.error("unknown user type: "+  details);
            throw new UnexpectedException("unknown user type!!");
        }
        String token = JWTUtil.createToken(details.getUsername(), key,id,role);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        System.out.println(token);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String tokenStr = JWTUtil.TOKEN_PREFIX + token;

        response.getWriter().println(objectMapper.writeValueAsString(details));
        response.setHeader("token",tokenStr);
    }
}
