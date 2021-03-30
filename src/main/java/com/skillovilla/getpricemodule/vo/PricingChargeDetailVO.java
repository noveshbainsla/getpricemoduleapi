package com.skillovilla.getpricemodule.vo;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PricingChargeDetailVO implements Serializable {
    private String chargeCode;
    private String chargeDescription;
    private BigDecimal chargeAmount;
}
