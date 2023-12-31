package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<CardEntity, Long> {

}
