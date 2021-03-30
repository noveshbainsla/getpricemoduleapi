package com.skillovilla.getpricemodule.businessobject;

import com.skillovilla.getpricemodule.ExceptionHandling.BusinessException;
import com.skillovilla.getpricemodule.domainobject.Country;
import com.skillovilla.getpricemodule.domainobject.Course;
import com.skillovilla.getpricemodule.domainobject.PriceType;
import com.skillovilla.getpricemodule.repository.CountryRepository;
import com.skillovilla.getpricemodule.repository.CourseRepository;
import com.skillovilla.getpricemodule.strategies.PricingStrategy;
import com.skillovilla.getpricemodule.vo.PriceGenerationParameterVO;
import com.skillovilla.getpricemodule.vo.PriceRequestVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PricingBusinessObjectImpl implements PricingBusinessObject {

    @Autowired
    @Qualifier("freePricingStrategy")
    private PricingStrategy freePricingStrategy;

    @Autowired
    @Qualifier("monthlyPricingStrategy")
    private PricingStrategy monthlyPricingStrategy;

    @Autowired
    @Qualifier("oneTimePricingStrategy")
    private PricingStrategy oneTimePricingStrategy;

    @Autowired
    private
    CountryRepository countryRepository;

    @Autowired
    CourseRepository courseRepository;

    private PricingStrategy getPricingStrategy(PriceGenerationParameterVO priceGenerationParameterVO) {
        PricingStrategy pricingStrategy;
        switch (priceGenerationParameterVO.getCourse().getPriceType()){
            case PriceType.MONTHLY :
                pricingStrategy = monthlyPricingStrategy;
                break;
            case PriceType.ONE_TIME :
                pricingStrategy = oneTimePricingStrategy;
                break;
            case PriceType.FREE:
                pricingStrategy = freePricingStrategy;
                break;
            default:
                throw new BusinessException("Invalid Price Type maintained for course, Please maintain one of OT/M/F");
        }

        return pricingStrategy;
    }

    @Override
    public PricingDetailVO getPrice(PriceRequestVO priceRequestVO) {
        Optional<Course> courseOptional = courseRepository.findById(priceRequestVO.getCourseId());
        List<Country> countries = countryRepository.findByCountryCode(priceRequestVO.getCountryCode());
        if(countries.isEmpty()){
            throw new BusinessException("Invalid country code provided, use USA/INDIA");
        }
        if(!courseOptional.isPresent()){
            throw new BusinessException("Invalid course id provided.");
        }

        PriceGenerationParameterVO priceGenerationParameterVO = PriceGenerationParameterVO.builder().country(countries.get(0))
                .course(courseOptional.get())
                .stateCode(priceRequestVO.getStateCode())
                .build();

        return getPricingStrategy(priceGenerationParameterVO).generateTotalPrice(priceGenerationParameterVO);
    }
}
