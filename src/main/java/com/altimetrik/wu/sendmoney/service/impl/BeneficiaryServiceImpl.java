package com.altimetrik.wu.sendmoney.service.impl;

import com.altimetrik.wu.sendmoney.dto.request.BeneficiaryDTO;
import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import com.altimetrik.wu.sendmoney.repository.BeneficiaryRepository;
import com.altimetrik.wu.sendmoney.service.BeneficiaryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {
    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Override
    public Beneficiary addBeneficiary(BeneficiaryDTO beneficiaryDTO) {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setSenderID(beneficiaryDTO.getSenderID());
        beneficiary.setAccountNumber(beneficiaryDTO.getAccountNumber());
        beneficiary.setCountry(beneficiaryDTO.getCountry());
        beneficiary.setFirstName(beneficiaryDTO.getFirstName());
        beneficiary.setLastName(beneficiaryDTO.getLastName());
        beneficiary.setIfscCode(beneficiaryDTO.getIfscCode());
        beneficiary.setStatus(beneficiaryDTO.getStatus());
        return beneficiaryRepository.save(beneficiary);

    }


    @Override
    public List<Beneficiary> getBeneficiaries(Long senderID) throws NotFoundException {
        List<Beneficiary> beneficiaryList = beneficiaryRepository.findBeneficiaryBySenderID(senderID);
        if (beneficiaryList.isEmpty()) {
            throw new NotFoundException("User Not Found");
        } else {
            return beneficiaryList;
        }
    }


}
