package com.company.poo;

import java.util.ArrayList;

public class Dieta {
    //atributos
    private ArrayList<Alimento> alimentos;
    private float energiaTotal = 0;
    private float proteinaTotal = 0;
    private float grasaTotal = 0;
    private float azucarTotal = 0;
    private float sodioTotal = 0;

    //builder
    public Dieta (ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
        for (Alimento alimento:
             alimentos) {
            energiaTotal += alimento.getEnergia();
            proteinaTotal += alimento.getProteinas();
            grasaTotal += alimento.getGrasas();
            azucarTotal += alimento.getAzucar();
            sodioTotal += alimento.getSodio();
        }
    }

    public Dieta () {}

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

    public float getSodioTotal() {
        return sodioTotal;
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

    public void setSodioTotal(float sodio) {
        this.sodioTotal = sodio;
    }
}
