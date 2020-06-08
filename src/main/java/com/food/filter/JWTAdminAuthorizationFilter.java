package com.food.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.food.model.vo.MerchantVO;
import com.food.utils.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAdminAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAdminAuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager,authenticationEntryPoint);

    }


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String tokenHeader = request.getHeader(JWTUtil.TOKEN_HEADER);

        // 如果请求头中没有Authorization信息则直接放行了
        if (tokenHeader == null || !tokenHeader.startsWith(JWTUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 如果请求头中有token，则进行解析，并且设置认证信息
        try {
            SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
        }catch (AuthenticationException failed){
            SecurityContextHolder.clearContext();
            this.onUnsuccessfulAuthentication(request,response,failed);
            this.getAuthenticationEntryPoint().commence(request, response, failed);
            return;
        }

        chain.doFilter(request,response);
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {

    }

    // 这里从token中获取用户信息并新建一个token
    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JWTUtil.TOKEN_PREFIX, "");
        try {
            JWTUtil.checkJWT(token);
        }catch (JWTVerificationException exception){
            exception.printStackTrace();
            throw new BadCredentialsException("invalid token, code 3333");
        }
        String username = JWTUtil.getUsername(token);
        String role = JWTUtil.getUserRole(token);
        Integer id = JWTUtil.getID(token);
        MerchantVO vo=new MerchantVO();
        vo.setUsername(username);
        vo.setId(id);
        vo.setRole(role);
        return new UsernamePasswordAuthenticationToken(vo, null,
                Collections.singleton(new SimpleGrantedAuthority(role))
        );
    }
}