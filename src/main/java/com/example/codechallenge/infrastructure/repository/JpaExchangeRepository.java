package com.example.codechallenge.infrastructure.repository;

import com.example.codechallenge.infrastructure.repository.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JpaExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}
