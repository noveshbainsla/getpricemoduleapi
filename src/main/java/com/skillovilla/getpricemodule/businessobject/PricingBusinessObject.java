package com.skillovilla.getpricemodule.businessobject;

import com.skillovilla.getpricemodule.vo.PriceRequestVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;

public interface PricingBusinessObject {
    PricingDetailVO getPrice(PriceRequestVO priceRequestVO);
}
