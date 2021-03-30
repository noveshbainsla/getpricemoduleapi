package com.skillovilla.getpricemodule.service;


import com.skillovilla.getpricemodule.vo.PricingDetailVO;

public interface CurrencyConversionService {
    void convertToCurrencyFromRupees(PricingDetailVO pricingDetailVO);
}
