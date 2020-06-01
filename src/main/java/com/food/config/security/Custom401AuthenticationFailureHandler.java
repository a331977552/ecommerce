package com.food.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.utils.ErrorDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class Custom401AuthenticationFailureHandler implements
        AuthenticationFailureHandler {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String message = failed.getCause() !=null ? failed.getCause().getMessage() : failed.getMessage();

        ErrorDetails errorDetails = ErrorDetails.unauthorized("Access Denied", message, request.getServletPath());
        String access_denied = objectMapper.writeValueAsString(errorDetails);
        System.out.println("onAuthenticationFailure :  "+access_denied +"  "+    message);
        log.info(message,access_denied);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().println(access_denied);

    }
}
