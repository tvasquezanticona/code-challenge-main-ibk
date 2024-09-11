package com.example.codechallenge.infrastructure.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double amount;
        private double convertedAmount;
        private String sourceCurrency;
        private String targetCurrency;
        private double exchangeRate;


    public ExchangeEntity(double amount, double convertedAmount, String sourceCurrency, String targetCurrency, double exchangeRate) {
        this.amount=amount;
        this.convertedAmount=convertedAmount;
        this.sourceCurrency=sourceCurrency;
        this.targetCurrency=targetCurrency;
    }
}
