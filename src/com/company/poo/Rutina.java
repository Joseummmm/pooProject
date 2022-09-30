package com.company.poo;

import java.util.ArrayList;

public class Rutina {
    //atributos
    private ArrayList<Ejercicio> ejercicios = new ArrayList<>();
    private int tiempoEstimado;
    private int series;

    //builder
    public Rutina (ArrayList<Ejercicio> ejercicios, int series) {
        this.ejercicios = ejercicios;
        this.tiempoEstimado = 0;
        for (Ejercicio x:
             ejercicios) {
            tiempoEstimado += x.getDuracionEstimada();
        }
        this.series = series;
    }

    //setters
    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    //getters
    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public int getSeries() {
        return series;
    }
}
