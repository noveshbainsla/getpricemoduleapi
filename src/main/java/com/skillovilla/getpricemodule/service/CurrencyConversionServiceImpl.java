package com.skillovilla.getpricemodule.service;

import com.skillovilla.getpricemodule.constants.Currency;
import com.skillovilla.getpricemodule.ExceptionHandling.BusinessException;
import com.skillovilla.getpricemodule.vo.PricingChargeDetailVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// This is service for fetching live currency conversion rates and converting from INR(base currency) to Other currency
@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private static final Map<String,BigDecimal> CURRENCY_CONVERSION_MAP = new HashMap<>();

    @PostConstruct
    public void postConstruct(){
        CURRENCY_CONVERSION_MAP.put("DLR",BigDecimal.valueOf(80));
        CURRENCY_CONVERSION_MAP.put("INR",BigDecimal.valueOf(1));
    }

    @Override
    public void convertToCurrencyFromRupees(PricingDetailVO pricingDetailVO) {
        BigDecimal conversionRatio = getConversionRatio(pricingDetailVO.getCurrency(),Currency.INDIAN_RUPEE.getEnumValue());
        pricingDetailVO.setPrice(pricingDetailVO.getPrice().divide(conversionRatio));
        pricingDetailVO.setTotalAmount(pricingDetailVO.getTotalAmount().divide(conversionRatio));
        for(PricingChargeDetailVO pricingChargeDetailVO: pricingDetailVO.getPricingChargeDetailVOS()){
            pricingChargeDetailVO.setChargeAmount(pricingChargeDetailVO.getChargeAmount().divide(conversionRatio));
        }
    }

    private BigDecimal getConversionRatio(String fromCurrency, String toCurrency) {
        // we can fetch live conversio rate from here
        if(CURRENCY_CONVERSION_MAP.containsKey(fromCurrency)){
            return CURRENCY_CONVERSION_MAP.get(fromCurrency);
        }else {
            throw new BusinessException("Invalid currency code - "+ fromCurrency + ", use DLR for Dollar");
        }
    }
}
