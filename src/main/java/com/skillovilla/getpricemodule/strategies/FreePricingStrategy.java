package com.skillovilla.getpricemodule.strategies;

import com.skillovilla.getpricemodule.domainobject.Course;
import com.skillovilla.getpricemodule.vo.PriceGenerationParameterVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service("freePricingStrategy")
public class FreePricingStrategy extends AbstractPricingStrategy {
    @Override
    public PricingDetailVO generateChargeLessPrice(PriceGenerationParameterVO priceGenerationParameterVO) {
        PricingDetailVO pricingDetailVO = PricingDetailVO.builder().pricingChargeDetailVOS(new ArrayList<>())
                .courseId(priceGenerationParameterVO.getCourse().getId())
                .currency(priceGenerationParameterVO.getCountry().getCurrencyCode())
                .priceType(priceGenerationParameterVO.getCourse().getPriceType())
                .price(BigDecimal.ZERO)
                .totalAmount(BigDecimal.ZERO).build();
        return pricingDetailVO;
    }

    @Override
    public void generateOtherCharges(PricingDetailVO pricingDetailVO, PriceGenerationParameterVO priceGenerationParameterVO){
    }
}
