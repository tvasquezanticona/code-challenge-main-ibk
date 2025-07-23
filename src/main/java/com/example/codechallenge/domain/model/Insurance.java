package com.example.codechallenge.domain.model;


    public class Insurance {
        private String marca;
        private String modelo;
        private int anio;
        private String tipoUso;
        private int edadConductor;

        public Insurance(String marca, int edadConductor, String tipoUso, int anio, String modelo) {
            this.marca = marca;
            this.edadConductor = edadConductor;
            this.tipoUso = tipoUso;
            this.anio = anio;
            this.modelo = modelo;
        }

// Getters y setters


        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public int getEdadConductor() {
            return edadConductor;
        }

        public void setEdadConductor(int edadConductor) {
            this.edadConductor = edadConductor;
        }

        public String getTipoUso() {
            return tipoUso;
        }

        public void setTipoUso(String tipoUso) {
            this.tipoUso = tipoUso;
        }

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }
    }


