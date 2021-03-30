package com.skillovilla.getpricemodule.service;

import com.skillovilla.getpricemodule.businessobject.PricingBusinessObject;
import com.skillovilla.getpricemodule.vo.PriceRequestVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PricingServiceImpl implements PricingService {

    @Autowired
    private PricingBusinessObject pricingBusinessObject;

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @Override
    @Transactional(readOnly = true)
    public PricingDetailVO getPrice(PriceRequestVO priceRequestVO) {
        PricingDetailVO pricingDetailVO = pricingBusinessObject.getPrice(priceRequestVO); // returns in INR
        currencyConversionService.convertToCurrencyFromRupees(pricingDetailVO);   // converts all amounts to currency of users
        return pricingDetailVO;
    }

}
