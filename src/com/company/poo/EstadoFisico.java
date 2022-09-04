package com.company.poo;

public class EstadoFisico {
    //atributos
    private float IMC;
    private float altura;
    private float peso;

    //builder
    public EstadoFisico(float IMC, float altura, float peso) {
        this.IMC = IMC;
        this.altura = altura;
        this.peso = peso;
    }

    //getters
    public float getIMC() {
        return IMC;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    //setters
    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}