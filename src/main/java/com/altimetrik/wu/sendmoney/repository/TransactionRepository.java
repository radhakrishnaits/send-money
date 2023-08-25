package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
