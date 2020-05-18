package com.food.controller.advicer;

import com.food.utils.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * global
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {



    @ExceptionHandler(value 
      = { Exception.class})
    @ResponseBody
    protected ResponseEntity<ErrorDetails> handleConflict(
      Exception ex, WebRequest request) {
    	String message = ex.getMessage();
		ex.printStackTrace();
        String description = request.getDescription(true);
        return ResponseEntity.badRequest().body(ErrorDetails.badRequest("Unknow Exception, Fix me",message,description));
}
    }