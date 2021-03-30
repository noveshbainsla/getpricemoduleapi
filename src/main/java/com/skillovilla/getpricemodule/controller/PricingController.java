package com.skillovilla.getpricemodule.controller;
import com.skillovilla.getpricemodule.service.PricingService;
import com.skillovilla.getpricemodule.vo.PriceRequestVO;
import com.skillovilla.getpricemodule.vo.PricingDetailVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("pricing")
public class PricingController {

    @Autowired
    private
    PricingService pricingService;

    @ApiOperation("This is getCoursePrice API.")
    @PostMapping("/getCoursePrice")
    @ApiResponses(@ApiResponse(code = 200,response = PricingDetailVO.class,message = "success"))
    public ResponseEntity<Object> getCourse(@Valid @RequestBody PriceRequestVO priceRequestVO) {
        PricingDetailVO pricingDetailVO = pricingService.getPrice(priceRequestVO);
        return ResponseEntity.status(HttpStatus.OK).body(pricingDetailVO);
    }
}
