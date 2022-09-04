package com.company.poo;

public class Alimento {
    //atributos
    private String nombre;
    private int cantidadEnGramos; //gramos que constituyen una porción
    private float energia;
    private float proteinas;
    private float grasas;
    private float azucares;
    private float sodio;

    //builder
    public Alimento (String nombre, int cantidadEnGramos, float energia, float proteinas, float grasas, float azucares, float sodio) {
        this.nombre = nombre;
        this.cantidadEnGramos = cantidadEnGramos;
        this.energia = energia;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.azucares = azucares;
        this.sodio = sodio;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadEnGramos(int cantidadEnGramos) {
        this.cantidadEnGramos = cantidadEnGramos;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public void setGrasaTotal(float grasas) {
        this.grasas = grasas;
    }

    public void setAzucaresTotales(float azucares) {
        this.azucares = azucares;
    }

    public void setSodio(float sodio) {
        this.sodio = sodio;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidadEnGramos() {
        return cantidadEnGramos;
    }
    public float getEnergia() {
        return energia;
    }

    public float getProteinas() {
        return proteinas;
    }

    public float getGrasas() {
        return grasas;
    }

    public float getAzucar() {
        return azucares;
    }

    public float getSodio() {
        return sodio;
    }
}
