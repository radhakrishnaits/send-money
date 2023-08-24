package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.BeneficiaryDTO;
import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import com.altimetrik.wu.sendmoney.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("V1/beneficiary")
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @PostMapping(value = "/add")
    ResponseEntity<Beneficiary> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = beneficiaryService.addBeneficiary(beneficiaryDTO);
        return ResponseEntity.ok().body(beneficiary);
    }


    @GetMapping(value = "/list/{senderID}")
    ResponseEntity<List<Beneficiary>> BeneficiaryList(@PathVariable Long senderID) {
        return ResponseEntity.ok().body(beneficiaryService.getBeneficiaries(senderID));
    }
}
