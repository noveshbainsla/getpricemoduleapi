package com.skillovilla.getpricemodule.strategies;

import com.skillovilla.getpricemodule.vo.PriceGenerationParameterVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;

public interface PricingStrategy {
    PricingDetailVO generateTotalPrice(PriceGenerationParameterVO priceGenerationParameterVO);
    PricingDetailVO generateChargeLessPrice(PriceGenerationParameterVO priceGenerationParameterVO);
}
