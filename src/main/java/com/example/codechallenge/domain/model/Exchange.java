package com.example.codechallenge.domain.model;


    public class Exchange {
        private double amount;
        private double convertedAmount;
        private String sourceCurrency;
        private String targetCurrency;
        private double exchangeRate;

        public Exchange(double amount, double convertedAmount, String sourceCurrency, String targetCurrency, double exchangeRate) {
            this.amount = amount;
            this.convertedAmount = convertedAmount;
            this.sourceCurrency = sourceCurrency;
            this.targetCurrency = targetCurrency;
            this.exchangeRate = exchangeRate;
        }

        // Getters y setters

        public double getAmount() {
            return amount;
        }

        public double getConvertedAmount() {
            return convertedAmount;
        }

        public String getSourceCurrency() {
            return sourceCurrency;
        }

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public double getExchangeRate() {
            return exchangeRate;
        }
    }


