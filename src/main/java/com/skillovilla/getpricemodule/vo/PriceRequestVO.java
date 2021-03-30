package com.skillovilla.getpricemodule.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@ApiModel("priceRequestVO")
public class PriceRequestVO {
    @NotNull
    @ApiModelProperty(notes = "This is the courseId. valid values from seed data are 1/2/3.", example = "1")
    private Long courseId;
    @ApiModelProperty(notes = "This is country code required for currency details and applicable charges/taxes. use USA/INDIA", example = "USA")
    @NotNull
    private String countryCode;
    @ApiModelProperty(notes = "This is state code required if state level taxes are also maintained like State GST. Not mandatory.")
    private String stateCode;
}
