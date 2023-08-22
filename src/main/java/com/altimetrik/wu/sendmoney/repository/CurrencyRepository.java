package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
