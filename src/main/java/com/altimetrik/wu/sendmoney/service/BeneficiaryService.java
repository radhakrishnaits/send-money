package com.altimetrik.wu.sendmoney.service;

import com.altimetrik.wu.sendmoney.dto.request.BeneficiaryDTO;
import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import javassist.NotFoundException;

import java.util.List;

public interface BeneficiaryService {

    Beneficiary addBeneficiary(BeneficiaryDTO beneficiaryDTO);

    List<Beneficiary> getBeneficiaries(Long senderID) throws NotFoundException;

}
