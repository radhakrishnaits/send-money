package com.altimetrik.wu.sendmoney.repository;

import com.altimetrik.wu.sendmoney.entity.ReceiverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiverRepository extends JpaRepository<ReceiverEntity,Long> {
}
