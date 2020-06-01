package com.food.filter;

import com.food.config.security.Custom401AuthenticationFailureHandler;
import com.food.config.security.CustomAuthenticationSuccessHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class JWTUserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private Custom401AuthenticationFailureHandler failureHandler = new Custom401AuthenticationFailureHandler();

    CustomAuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();

    public JWTUserAuthenticationFilter(AuthenticationManager authenticationManager, String userLoginUrl) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl(userLoginUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }




        String username = obtainUsername(request);
        String password = obtainPassword(request);
        System.out.println("attemptAuthentication "+username + password);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }
        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

    // 从输入流中获取到登录的信息
            return authenticationManager.authenticate(authRequest);
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        successHandler.onAuthenticationSuccess(request,response,authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        failureHandler.onAuthenticationFailure(request,response,failed);

    }
}