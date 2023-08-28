package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.ReponseDTO;
import com.altimetrik.wu.sendmoney.dto.request.RequestDTO;
import com.altimetrik.wu.sendmoney.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReceiverController {
    private final ReceiverService receiverService;

    @Autowired
    public ReceiverController(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    @GetMapping("/transaction/rates")
    public ResponseEntity<ReponseDTO> calculateReceiveAmount(@RequestBody RequestDTO requestDTO) {
        ReponseDTO reponseDTO = receiverService.getReceiverAmount(requestDTO);
        return ResponseEntity.ok(reponseDTO);
    }

}
