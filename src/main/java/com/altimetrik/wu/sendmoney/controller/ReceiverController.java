package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReceiverController {
    private final ReceiverService receiverService;
    @Autowired
    public ReceiverController(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    @GetMapping("/receive-amount")
    //service layer logiv implementation -reponse

    public ResponseEntity<Map<String, Double>> calculateReceiveAmount(@RequestParam double sendAmount){
        double conversionRate = 0.9;
        double feeAmount =5.0;
        double receiveAmount = sendAmount*conversionRate-feeAmount;
        Map<String, Double> response = new HashMap<>();
        response.put("sendAmount",sendAmount);
        response.put("receiveAmount",receiveAmount);
        return ResponseEntity.ok(response);
    }
}
