package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    List<Beneficiary> findBeneficiaryBySenderID(Long senderID);
}
