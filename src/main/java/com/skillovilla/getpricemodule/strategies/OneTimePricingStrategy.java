package com.skillovilla.getpricemodule.strategies;

import com.skillovilla.getpricemodule.vo.PriceGenerationParameterVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.stereotype.Service;

@Service("oneTimePricingStrategy")
public class OneTimePricingStrategy extends AbstractPricingStrategy {

    @Override
    public PricingDetailVO generateChargeLessPrice(PriceGenerationParameterVO priceGenerationParameterVO) {
        return PricingDetailVO.builder()
                .courseId(priceGenerationParameterVO.getCourse().getId())
                .currency(priceGenerationParameterVO.getCountry().getCurrencyCode())
                .priceType(priceGenerationParameterVO.getCourse().getPriceType())
                .price(priceGenerationParameterVO.getCourse().getAmount())
                .totalAmount(priceGenerationParameterVO.getCourse().getAmount())
                .build();
    }
}
