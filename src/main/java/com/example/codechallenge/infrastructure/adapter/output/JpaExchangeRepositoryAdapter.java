package com.example.codechallenge.infrastructure.adapter.output;

import com.example.codechallenge.domain.model.Exchange;
import com.example.codechallenge.domain.port.ExchangeRepositoryPort;
import com.example.codechallenge.infrastructure.repository.ExchangeEntity;
import com.example.codechallenge.infrastructure.repository.JpaExchangeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaExchangeRepositoryAdapter implements ExchangeRepositoryPort {

    private final JpaExchangeRepository jpaRepository;

    public JpaExchangeRepositoryAdapter(JpaExchangeRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }


    public Exchange save(Exchange exchange) {
        ExchangeEntity entity =new ExchangeEntity(
                exchange.getAmount(),
                exchange.getConvertedAmount(),
                exchange.getSourceCurrency(),
                exchange.getTargetCurrency(),
                exchange.getExchangeRate()
        );
        ExchangeEntity savedEntity = jpaRepository.save(entity);
        return new Exchange(
                savedEntity.getAmount(),
                savedEntity.getConvertedAmount(),
                savedEntity.getSourceCurrency(),
                savedEntity.getTargetCurrency(),
                savedEntity.getExchangeRate()
        );
    }


}
