package com.skillovilla.getpricemodule.ExceptionHandling;

import com.skillovilla.getpricemodule.GetpricemoduleApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger LOGGER= LoggerFactory.getLogger(GetpricemoduleApplication.class);
    private static final String FAILED = "FAILED";

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> handle(Exception ex){
        if(ex instanceof BusinessException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(FAILED,ex.getMessage()));
        } else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(FAILED,"Some Error Occured , please contact system administrator."));
        }
    }
}
