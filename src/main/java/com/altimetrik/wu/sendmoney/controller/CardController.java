package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.entity.CardEntity;
import com.altimetrik.wu.sendmoney.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;
    @Autowired
    public CardController(CardService cardService){
        this.cardService=cardService;
    }
    @PostMapping("/card")
    public ResponseEntity<CardEntity>saveCard(@RequestBody CardEntity cardEntity){
        CardEntity savedCard= cardService.saveCard(cardEntity);
        return ResponseEntity.ok(savedCard);
    }
}
