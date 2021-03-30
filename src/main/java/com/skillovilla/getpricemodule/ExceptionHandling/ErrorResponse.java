package com.skillovilla.getpricemodule.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @AllArgsConstructor
public class ErrorResponse implements Serializable {
    private String status;
    private String reason;
}
