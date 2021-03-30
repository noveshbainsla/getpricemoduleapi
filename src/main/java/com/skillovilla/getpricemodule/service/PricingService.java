package com.skillovilla.getpricemodule.service;

import com.skillovilla.getpricemodule.vo.PriceRequestVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;

public interface PricingService {

    PricingDetailVO getPrice(PriceRequestVO priceRequestVO);
}
