package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.response.ReceiverReponse;
import com.altimetrik.wu.sendmoney.dto.request.ReceiverRequest;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiverController {
    @Autowired
    ReceiverService receiverService;

    @ApiOperation(value = "Get list of all details of Receiver Amount", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Receiver Amount"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/transaction/rates")
    ResponseEntity<ReceiverReponse> calculateReceiveAmount(@RequestParam ReceiverRequest receiverRequest) {
        ReceiverReponse receiverReponse = receiverService.getReceiverAmount(receiverRequest);
        return ResponseEntity.ok().body(receiverReponse);
    }

}
