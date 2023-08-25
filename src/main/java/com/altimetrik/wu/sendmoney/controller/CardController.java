package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @Autowired
    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService){
        this.cardService=cardService;
    }
    @PostMapping("/card/save")
    public ResponseEntity<CardEntity>saveCard(@RequestBody RequestDTO requestDTO){
        CardEntity savedCard= cardService.saveCard(requestDTO);
        return ResponseEntity.ok(savedCard);
    }
}
