package com.skillovilla.getpricemodule.strategies;

import com.skillovilla.getpricemodule.domainobject.ChargeDefinition;
import com.skillovilla.getpricemodule.repository.ChargeDefinitionRepository;
import com.skillovilla.getpricemodule.vo.PriceGenerationParameterVO;
import com.skillovilla.getpricemodule.vo.PricingChargeDetailVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPricingStrategy implements PricingStrategy {
    private static final String CONVERSION_FEES = "CV";

    @Autowired
    private
    ChargeDefinitionRepository chargeDefinitionRepository;

    @Override
    public PricingDetailVO generateTotalPrice(PriceGenerationParameterVO priceGenerationParameterVO){
        PricingDetailVO pricingDetailVO = generateChargeLessPrice(priceGenerationParameterVO); // for generating plain fees of charge excluding taxes/conversion fees etc.
        generateOtherCharges(pricingDetailVO,priceGenerationParameterVO);  // for adding other taxes and conversion fees.
        return pricingDetailVO;
    }


    // FOR GENERATING COMMON CHARGES APPLICABLE ON ALL PRICING STRATEGIES
    public void generateOtherCharges(PricingDetailVO pricingDetailVO, PriceGenerationParameterVO priceGenerationParameterVO){

        BigDecimal totalAmount = pricingDetailVO.getPrice();

        List<ChargeDefinition> allCharges = (List<ChargeDefinition>) chargeDefinitionRepository.findAll();
        List<ChargeDefinition> applicableOtherCharges = new ArrayList<>();
        ChargeDefinition applicableConversionCharge=null;
        for(ChargeDefinition chargeDefinition: allCharges){
            if(applicableBasedOnCountryAndStateCode(chargeDefinition,priceGenerationParameterVO)){
                if(chargeDefinition.getChargeCode().equals(CONVERSION_FEES))
                    applicableConversionCharge = chargeDefinition;
                else
                    applicableOtherCharges.add(chargeDefinition);
            }
        }

        List<PricingChargeDetailVO> pricingChargeDetailVOS = new ArrayList<>();
        for(ChargeDefinition chargeDefinition: applicableOtherCharges){
            BigDecimal chargeAmount = getChargeAmount(chargeDefinition,priceGenerationParameterVO);
            totalAmount = totalAmount.add(chargeAmount);
            PricingChargeDetailVO pricingChargeDetailVO = PricingChargeDetailVO.builder()
                    .chargeAmount(chargeAmount)
                    .chargeCode(chargeDefinition.getChargeCode())
                    .chargeDescription(chargeDefinition.getChargeDescription())
                    .build();
            pricingChargeDetailVOS.add(pricingChargeDetailVO);
        }


        //conversionCharge
        if(applicableConversionCharge!=null){
            BigDecimal chargeAmount = getChargeAmount(applicableConversionCharge,priceGenerationParameterVO);
            totalAmount = totalAmount.add(chargeAmount);
            PricingChargeDetailVO pricingChargeDetailVO = PricingChargeDetailVO.builder().chargeAmount(chargeAmount)
                    .chargeCode(applicableConversionCharge.getChargeCode())
                    .chargeDescription(applicableConversionCharge.getChargeDescription())
                    .build();
            pricingChargeDetailVOS.add(pricingChargeDetailVO);
        }

        pricingDetailVO.setTotalAmount(totalAmount);
        pricingDetailVO.setPricingChargeDetailVOS(pricingChargeDetailVOS);
    }

    private boolean applicableBasedOnCountryAndStateCode(ChargeDefinition chargeDefinition, PriceGenerationParameterVO priceGenerationParameterVO){
        return (chargeDefinition.getCountryCode()==null || chargeDefinition.getCountryCode().equals(priceGenerationParameterVO.getCountry().getCountryCode())) &&
                (chargeDefinition.getStateCode()==null || chargeDefinition.getStateCode().equals(priceGenerationParameterVO.getStateCode()));
    }

    private BigDecimal getChargeAmount(ChargeDefinition chargeDefinition, PriceGenerationParameterVO priceGenerationParameterVO){
        if(chargeDefinition.getRateBased()){
            return priceGenerationParameterVO.getCourse().getAmount().multiply(chargeDefinition.getRate()).divide(BigDecimal.valueOf(100));
        }else{
            return chargeDefinition.getAmount();
        }
    }

}
