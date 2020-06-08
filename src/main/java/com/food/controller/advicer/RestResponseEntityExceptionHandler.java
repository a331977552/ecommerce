package com.food.controller.advicer;

import com.food.utils.BaseEntityException;
import com.food.utils.ErrorDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * global
 */
@Log4j2
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
        return ResponseEntity.badRequest().body(ErrorDetails.badRequest(message,"Unknow Exception, Fix me",description));
}

    @ExceptionHandler(value
            = { BaseEntityException.class})
    @ResponseBody
    protected ResponseEntity<ErrorDetails> handleConflict(
            BaseEntityException ex, WebRequest request) {
        String errorMsg = "";
        if(ex.getArgs().length == 0){
            errorMsg = ex.getTitle();
            log.error(ex);
        }else{
            errorMsg = ex.getArgs()[0];
        }
        return ResponseEntity.badRequest().body(ErrorDetails.badRequest(ex.getTitle(),errorMsg , request.getDescription(true)));
    }


}