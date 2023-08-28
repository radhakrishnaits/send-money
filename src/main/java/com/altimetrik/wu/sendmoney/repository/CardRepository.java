package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
