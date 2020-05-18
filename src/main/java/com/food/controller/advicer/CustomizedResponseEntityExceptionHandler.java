package com.food.controller.advicer;

import com.food.utils.BaseEntityException;
import com.food.utils.ErrorDetails;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @Autowired
  private  MessageSource messageSource;


  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request) {
    List<ObjectError> model = ex.getBindingResult().getAllErrors();
    StringBuilder builder=new StringBuilder();

    for (ObjectError objectError : model) {
      String message;
      try {
       message = messageSource.getMessage(objectError.getDefaultMessage(), null, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {
      message="fix me:  no localized message:  "+ objectError.getDefaultMessage();
    }
      builder.append(message).append(", ");
    }
    builder.delete(builder.length()-2,builder.length());

    return ResponseEntity.badRequest().body(ErrorDetails.badRequest("no such entity",builder.toString(), request.getDescription(true)));
  }


    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return ResponseEntity.badRequest().body(ErrorDetails.badRequest("request body abnormal",ex.getMessage(), request.getDescription(true)));
    }

    @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    String message = null;
    try {
      message = messageSource.getMessage(ex.getMessage(), null, LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {

      message="fix me:  no localized message:  "+ ex.getMessage();
    }
    return ResponseEntity.badRequest().body(ErrorDetails.badRequest("request body abnormal", message, request.getDescription(true)));
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

    return ResponseEntity.badRequest().body(ErrorDetails.badRequest("http request method not supported",ex.getMessage(), request.getDescription(true)));
  }

  @ExceptionHandler(value
          = { BaseEntityException.class})
  @ResponseBody
  protected ResponseEntity<ErrorDetails> handleConflict(
          BaseEntityException ex, WebRequest request) {
    String message;
    try {
      message  = messageSource.getMessage(ex.getTitle(), ex.getArgs(), LocaleContextHolder.getLocale());
    } catch (NoSuchMessageException e) {

      message="fix me:  no localized message:  "+ ex.getMessage();
    }

    return ResponseEntity.badRequest().body(ErrorDetails.badRequest(ex.getTitle(),message, request.getDescription(true)));
  }

}