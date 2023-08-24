package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import com.altimetrik.wu.sendmoney.service.SenderAllowedCountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SenderAllowedCountryController {
    @Autowired
    private SenderAllowedCountryService senderAllowedCountryService;

    @ApiOperation(value = "Get all available currencies", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/country/{country_code}")
    public ResponseEntity<List<SenderAllowedCountry>> senderAllowedCountry(@PathVariable(value = "country_code", required = false) String countryCode) {
        return ResponseEntity.ok(senderAllowedCountryService.gSenderAllowedCountries(countryCode));
    }
}
