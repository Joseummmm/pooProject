package com.company.poo;

public class Ejercicio {
    //atributos
    private String nombre;
    private int repeticiones;
    private int duracionEstimada; //en segundos
    private float caloriasQuemadasPorMinuto; //por minuto

    //builder
    public Ejercicio(String nombre, int repeticiones, int duracionEstimada, float caloriasQuemadasPorMinuto) {
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.duracionEstimada = duracionEstimada;
        this.caloriasQuemadasPorMinuto = caloriasQuemadasPorMinuto;
    }

    //setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public void setCaloriasQuemadasPorMinuto(int caloriasQuemadasPorMinuto) {
        this.caloriasQuemadasPorMinuto = caloriasQuemadasPorMinuto;
    }

    //getter
    public String getNombre() {
        return nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public float getCaloriasQuemadasPorMinuto() {
        return caloriasQuemadasPorMinuto;
    }
}
