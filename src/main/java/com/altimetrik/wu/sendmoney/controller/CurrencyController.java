package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.constats.AppConstants;
import com.altimetrik.wu.sendmoney.dto.request.CurrencyRequest;
import com.altimetrik.wu.sendmoney.dto.response.AppResponse;
import com.altimetrik.wu.sendmoney.entity.Currency;
import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.service.CurrencyService;
import com.altimetrik.wu.sendmoney.service.SenderAllowedCountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private SenderAllowedCountryService senderAllowedCountryService;


    @ApiOperation(value = "Store all currencies", response = ResponseEntity.class)
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

    @ApiOperation(value = "Get all available currencies", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/country")
    ResponseEntity<AppResponse<List<Currency>>> getCurrency() {
        return ResponseEntity.ok().body(new AppResponse<>(currencyService.getCurrency(), AppConstants.SUCCESS, HttpStatus.OK));
    }

    @ApiOperation(value = "Get all available currencies", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/country/{country_code}")
    public ResponseEntity<AppResponse<List<SenderAllowedCountry>>> senderAllowedCountry(@PathVariable(value = "country_code", required = false) String countryCode)  {
        List<SenderAllowedCountry> response = null;
        AppResponse<List<SenderAllowedCountry>> appResponse = null;
        try {
            response = senderAllowedCountryService.getSenderAllowedCountries(countryCode);
            appResponse = new AppResponse<>(response, AppConstants.SUCCESS, HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new AppResponse<>(null, e.getMessage(), HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.ok(appResponse);

    }
}
