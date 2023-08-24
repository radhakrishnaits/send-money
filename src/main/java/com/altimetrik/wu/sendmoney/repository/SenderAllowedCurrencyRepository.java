package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.SenderAllowedCountry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SenderAllowedCurrencyRepository extends JpaRepository <SenderAllowedCountry, Long> {

    List<SenderAllowedCountry> getSenderAllowedCountryByCountryCode(String countryCode);
}
