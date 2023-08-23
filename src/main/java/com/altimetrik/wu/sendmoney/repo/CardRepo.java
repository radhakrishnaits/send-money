package com.altimetrik.wu.sendmoney.repo;

import com.altimetrik.wu.sendmoney.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<CardEntity, Long> {

}
