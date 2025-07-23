package com.example.codechallenge.application.service;

import com.example.codechallenge.domain.InsuranceQuote;
import com.example.codechallenge.domain.InsuranceRule;
import com.example.codechallenge.domain.model.Exchange;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CalculateInsuranceUseCase {
    private static final double baseprima = 500.00;
    private final List<InsuranceRule> rules;
    private final Map<InsuranceQuote, Exchange> cache = new ConcurrentHashMap<>();

    //public Mono<String,Object> calculatesimulate



    public CalculateInsuranceUseCase() {
        this.rules = List.of(
                new InsuranceRule("+15% si el año del vehículo > 2015",(q, p) -> q.getAnio() > 2015 ? p * 1.15 : p),
                new InsuranceRule("+10% si el tipo de uso es \"carga\"",((insuranceQuote, aDouble) -> "carga".equalsIgnoreCase(insuranceQuote.getTipoUso()) ? aDouble * 1.10  : aDouble  )),
                new InsuranceRule("-5% si la edad del conductor > 50 años",(insuranceQuote, aDouble) -> insuranceQuote.getEdadConductor() > 50 ? aDouble * 0.95 : aDouble),
                new InsuranceRule("+20% si la marca es BMW", (insuranceQuote, aDouble) -> "BMW".equalsIgnoreCase(insuranceQuote.getMarca()) ? aDouble * 1.20 : aDouble),
                new InsuranceRule("+10% si la marca es Audi",(insuranceQuote, aDouble) -> "AUDI".equalsIgnoreCase(insuranceQuote.getMarca()) ? aDouble * 1.10 : aDouble));

    }

    public Mono<Exchange> calcular(InsuranceQuote quote) {
        return Mono.fromSupplier(() -> {
            if (cache.containsKey(quote)) {
                return cache.get(quote);
            }
            double total = baseprima;
            List<String> ajustes = new ArrayList<>();
            boolean status = false;


            for (InsuranceRule regla : rules) {
               if(status&&isReglaDeMarca(regla))continue;

                double old = total;
                total = regla.calculate(quote, total);
                if (Double.compare(old, total) != 0) {
                    ajustes.add(regla.getDescripcion());
                   if (isReglaDeMarca(regla)) {
                       status = true;
                   }

                }
            }

            Exchange resultado = new Exchange(baseprima, total, ajustes);
            cache.put(quote,resultado);

            return  resultado;
        });
    }



    private boolean isReglaDeMarca(InsuranceRule regla) {
        String desc = regla.getDescripcion().toLowerCase();
        return desc.contains("marca es bmw") || desc.contains("marca es audi");
    }


}
