package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.constats.AppConstants;
import com.altimetrik.wu.sendmoney.dto.request.CardRequest;
import com.altimetrik.wu.sendmoney.dto.response.AppResponse;
import com.altimetrik.wu.sendmoney.entity.Card;
import com.altimetrik.wu.sendmoney.service.CardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CardController {
    @Autowired
    CardService cardService;

    @ApiOperation(value = "Card Details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully stored the card details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(value = "/card/save")
    ResponseEntity<AppResponse<Card>> saveCard(@RequestBody CardRequest cardRequest) {
        return ResponseEntity.ok().body(new AppResponse<>(cardService.saveCard(cardRequest), AppConstants.SUCCESS, HttpStatus.OK));
    }
}
