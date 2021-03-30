package com.skillovilla.getpricemodule.constants;


import lombok.Getter;

public enum Currency {
    DOLLER("DLR"),
    INDIAN_RUPEE("INR");

    @Getter
    private String enumValue;

    private Currency(String enumValue){
        this.enumValue = enumValue;
    }


}
