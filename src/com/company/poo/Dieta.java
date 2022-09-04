package com.company.poo;

import java.util.ArrayList;

public class Dieta {
    //atributos
    private ArrayList<Alimento> alimentos;
    private float energiaTotal;
    private float proteinaTotal;
    private float grasaTotal;
    private float azucarTotal;
    private float sodio;

    //builder
    public Dieta (ArrayList<Alimento> alimentos) {
        this.energiaTotal = 0;
        this.proteinaTotal = 0;
        this.grasaTotal = 0;
        this.azucarTotal = 0;
        this.sodio = 0;
        this.alimentos = alimentos;
        for (Alimento alimento:
             alimentos) {
            energiaTotal += alimento.getEnergia();
            proteinaTotal += alimento.getProteinas();
            grasaTotal += alimento.getGrasas();
            azucarTotal += alimento.getAzucar();
            sodio += alimento.getSodio();
        }
    }

    //getters
    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public float getEnergiaTotal() {
        return energiaTotal;
    }

    public float getProteinaTotal() {
        return proteinaTotal;
    }

    public float getGrasaTotal() {
        return grasaTotal;
    }

    public float getAzucarTotal() {
        return azucarTotal;
    }

    public float getSodio() {
        return sodio;
    }

    //setters
    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public void setEnergiaTotal(float energiaTotal) {
        this.energiaTotal = energiaTotal;
    }

    public void setProteinaTotal(float proteinaTotal) {
        this.proteinaTotal = proteinaTotal;
    }

    public void setGrasaTotal(float grasaTotal) {
        this.grasaTotal = grasaTotal;
    }

    public void setAzucarTotal(float azucarTotal) {
        this.azucarTotal = azucarTotal;
    }

    public void setSodio(float sodio) {
        this.sodio = sodio;
    }
}
