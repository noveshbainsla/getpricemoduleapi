package com.skillovilla.getpricemodule.ExceptionHandling;

public class BusinessException extends RuntimeException {

    public BusinessException(String message){
        super(message);
    }
}
