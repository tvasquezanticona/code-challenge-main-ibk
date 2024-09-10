package com.example.codechallenge.model.entity;

import com.example.codechallenge.model.api.ExchangeRateRequest;
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
public class ConversionHistory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double amount;
        private double convertedAmount;
        private String sourceCurrency;
        private String targetCurrency;
        private double exchangeRate;

        public ConversionHistory(ExchangeRateRequest request){
            this.amount=request.getAmount();
            this.convertedAmount= request.getAmount();
            this.sourceCurrency=request.getSourceCurrency();
            this.targetCurrency=request.getTargetCurrency();
            this.exchangeRate=request.getExchangeRate();

        }
    }
