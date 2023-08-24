package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.TransactionRequest;
import com.altimetrik.wu.sendmoney.entity.Transactions;
import com.altimetrik.wu.sendmoney.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @ApiOperation(value = "Get list of all Transactions",response = TransactionRequest.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the transaction"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    ResponseEntity<List<Transactions>> getAllTransactions() {
        return ResponseEntity.ok().body(transactionService.getAllTransaction());
    }

    @ApiOperation(value = "Save transaction details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saved transaction details successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/transaction/save", method = RequestMethod.POST)
    ResponseEntity<String> addCurrency(@RequestBody TransactionRequest transactionRequest) {
        long mtcn = transactionService.saveTransaction(transactionRequest);
        return ResponseEntity.ok("Transaction was successful. Reference number: " + mtcn);
    }
}
