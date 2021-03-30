package com.skillovilla.getpricemodule.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
@ApiModel("pricingDetailVO")
public class PricingDetailVO implements Serializable {
    @ApiModelProperty(notes = "course id of the course queried for.")
    private Long courseId;
    @ApiModelProperty(notes = "Price excluding taxes and charges.")
    private BigDecimal price;
    @ApiModelProperty(notes = "Price including taxes and charges.")
    private BigDecimal totalAmount;
    @ApiModelProperty(notes = "currency in which amount are being represented.")
    private String currency;
    @ApiModelProperty(notes = "Type of price like One Time/Monthly/Free")
    private String priceType;
    @ApiModelProperty(notes = "No of months in case of Monthly(M).")
    private Integer months;
    @ApiModelProperty(notes = "taxes and charges components other than base price.")
    private List<PricingChargeDetailVO> pricingChargeDetailVOS;
}
