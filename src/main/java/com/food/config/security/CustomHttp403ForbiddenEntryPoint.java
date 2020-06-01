package com.food.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.utils.ErrorDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
public class CustomHttp403ForbiddenEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
        throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String message = exception.getCause() !=null ? exception.getCause().getMessage() : exception.getMessage();
        log.info(message);
        System.out.println("JWTAuthenticationEntryPoint "+  message);

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().println( objectMapper.writeValueAsString(ErrorDetails.forbidden("Access Denied 2", message, request.getServletPath())));

    }

}