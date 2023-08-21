package com.altimetrik.wu.sendmoney.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {

    @GetMapping("/countries")
    String convertCurrency() {
        return("USA");
    }
}
