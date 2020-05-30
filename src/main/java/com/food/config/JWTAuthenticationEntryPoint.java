package com.food.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
        throws IOException, ServletException {
    response.setStatus(403);
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

    String message;
    if (exception.getCause() != null) {
        message = exception.getCause().getMessage();
    } else {
        message = exception.getMessage();
    }
    byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));
    response.getOutputStream().write(body);
    }

}