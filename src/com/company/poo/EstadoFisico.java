package com.company.poo;

public class EstadoFisico {
    //atributos
    private float IMC;
    private float altura;
    private float peso;

    //builder
    public EstadoFisico(float altura, float peso) {
        this.altura = altura;
        this.peso = peso;
        this.IMC = peso / (altura * altura);
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