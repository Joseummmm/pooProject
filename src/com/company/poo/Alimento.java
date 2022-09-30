package com.company.poo;

public class Alimento {
    //atributos
    private String nombre;
    private String tipo;
    private int cantidadEnGramos; //gramos que constituyen una porción
    private float energia;
    private float proteinas;
    private float grasas;
    private float azucares;
    private float sodio;

    //builder
    public Alimento (String nombre, String tipo, int cantidadEnGramos, float energia, float proteinas, float grasas, float azucares, float sodio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadEnGramos = cantidadEnGramos;
        this.energia = energia;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.azucares = azucares;
        this.sodio = sodio;
    }

    //setters and getters
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


    public void setSodio(float sodio) {
        this.sodio = sodio;
    }

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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    public float getAzucares() {
        return azucares;
    }

    public void setAzucares(float azucares) {
        this.azucares = azucares;
    }
}
