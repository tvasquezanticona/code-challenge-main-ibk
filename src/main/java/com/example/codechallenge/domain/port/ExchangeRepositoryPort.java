package com.example.codechallenge.domain.port;

import com.example.codechallenge.domain.model.Exchange;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepositoryPort {
    Exchange save(Exchange exchange);

}
