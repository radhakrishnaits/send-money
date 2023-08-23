package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.Countries;
import com.altimetrik.wu.sendmoney.dto.request.CurrencyRequest;
import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.service.CurrencyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("V1/currencies")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;


    @ApiOperation(value = "Store all currencies",response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    ResponseEntity<String> addCurrency(@RequestBody List<CurrencyRequest> currencyRequests) {
        currencyService.addCurrency(currencyRequests);
        return ResponseEntity.ok("created");
    }

    @ApiOperation(value = "Get all available currencies",response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    ResponseEntity<List<Currency>> getCurrency() {
        return ResponseEntity.ok().body(currencyService.getCurrency());
    }
}
