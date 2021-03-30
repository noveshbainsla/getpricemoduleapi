package com.skillovilla.getpricemodule.vo;

import com.skillovilla.getpricemodule.domainobject.Country;
import com.skillovilla.getpricemodule.domainobject.Course;
import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class PriceGenerationParameterVO {
    private Course course;
    private Country country;
    private String stateCode;
}
