package com.example.codechallenge.infrastructure.adapter.input;

import com.example.codechallenge.application.service.ExchangeService;
import com.example.codechallenge.domain.model.Exchange;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${application.api.path}")
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping(path = "/convert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeResponse applyExchangeRate(@RequestParam double amount, @RequestParam String sourceCurrency, @RequestParam String targetCurrency) {
        Exchange exchange = exchangeService.convert(amount, sourceCurrency, targetCurrency);
        return new ExchangeResponse(exchange.getAmount(), exchange.getConvertedAmount(), exchange.getSourceCurrency(), exchange.getTargetCurrency(), exchange.getExchangeRate());
    }

    public static class ExchangeResponse {
        private double originalAmount;
        private double convertedAmount;
        private String sourceCurrency;

        public double getOriginalAmount() {
            return originalAmount;
        }

        public void setOriginalAmount(double originalAmount) {
            this.originalAmount = originalAmount;
        }

        public double getConvertedAmount() {
            return convertedAmount;
        }

        public void setConvertedAmount(double convertedAmount) {
            this.convertedAmount = convertedAmount;
        }

        public String getSourceCurrency() {
            return sourceCurrency;
        }

        public void setSourceCurrency(String sourceCurrency) {
            this.sourceCurrency = sourceCurrency;
        }

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }

        public double getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(double exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        private String targetCurrency;
        private double exchangeRate;

        public ExchangeResponse(double originalAmount, double convertedAmount, String sourceCurrency, String targetCurrency, double exchangeRate) {
            this.originalAmount = originalAmount;
            this.convertedAmount = convertedAmount;
            this.sourceCurrency = sourceCurrency;
            this.targetCurrency = targetCurrency;
            this.exchangeRate = exchangeRate;
        }

        // Getters y setters
    }
}
