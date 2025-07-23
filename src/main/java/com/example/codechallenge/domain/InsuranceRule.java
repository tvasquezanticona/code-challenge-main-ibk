package com.example.codechallenge.domain;

import lombok.Getter;

import java.util.function.BiFunction;

public class InsuranceRule {

    @Getter
    private  final String descripcion;
    private final BiFunction<InsuranceQuote, Double, Double> rule;


    public InsuranceRule(String descripcion, BiFunction<InsuranceQuote, Double, Double> rule) {
        this.descripcion = descripcion;
        this.rule = rule;
    }

    public double calculate(InsuranceQuote quote,double price) {
        return rule.apply(quote,price);
    }

}
