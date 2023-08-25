package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.TransferRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRateRepository extends JpaRepository<TransferRate, Long> {
    @Query(value ="select * from transfer_rate tr where tr.from_currency =:fromCurrency and tr.to_currency=:toCurrency",nativeQuery = true)
    public TransferRate getRatebyCurency(String fromCurrency, String toCurrency);

}
