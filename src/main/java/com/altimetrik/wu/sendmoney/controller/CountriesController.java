package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.Countries;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

    @ApiOperation(value = "Get list of all Countries",response = Countries.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the country"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    String convertCurrency() {
        return("USA");
    }
}
