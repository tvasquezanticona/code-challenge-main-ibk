package com.example.codechallenge.domain.model;

import java.util.List;

public class Exchange {

    private double precioBase;
    private  List<String> ajustesAplicados;
    private double primaTotal;


    public Exchange(double precioBase, double primaTotal, List<String> ajustesAplicados) {
        this.precioBase = precioBase;
        this.primaTotal = primaTotal;
        this.ajustesAplicados = ajustesAplicados;
    }

    // Getters y setters


    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<String> getAjustesAplicados() {
        return ajustesAplicados;
    }

    public void setAjustesAplicados(List<String> ajustesAplicados) {
        this.ajustesAplicados = ajustesAplicados;
    }

    public double getPrimaTotal() {
        return primaTotal;
    }

    public void setPrimaTotal(double primaTotal) {
        this.primaTotal = primaTotal;
    }
}
