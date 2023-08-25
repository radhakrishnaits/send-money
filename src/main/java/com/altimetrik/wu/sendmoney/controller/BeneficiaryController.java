package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.BeneficiaryDTO;
import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import com.altimetrik.wu.sendmoney.service.BeneficiaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    @Autowired
    BeneficiaryService beneficiaryService;

    @ApiOperation(value = "Store Beneficiary details", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully stored the beneficiary details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(value = "/add")
    ResponseEntity<Beneficiary> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = beneficiaryService.addBeneficiary(beneficiaryDTO);
        return ResponseEntity.ok().body(beneficiary);
    }


    @ApiOperation(value = "Get list of all Beneficiaries against the senderID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved beneficiaries against each senderID"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/list/{senderID}")
    ResponseEntity<List<Beneficiary>> BeneficiaryList(@PathVariable Long senderID) {
        return ResponseEntity.ok().body(beneficiaryService.getBeneficiaries(senderID));
    }
}
