package com.company.poo;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Alimento lentejas = new Alimento("Lentejas",60,211f, 14.8f,0.7f,0f,3.6f);
        Alimento fideos = new Alimento("Fideos",80, 258f, 9.6f, 0.9f,2.3f,11f);
        Alimento salsaTomate = new Alimento("Salsa de tomate",20, 10f,0.3f,0,1.2f,66f);
        Alimento panDeMolde = new Alimento("Pan de molde",52, 127f, 5.2f,1.1f,3.6f,204);
        Alimento arroz = new Alimento("Arroz",50, 169f,3.1f,0.5f,0.3f,0.9f);

        ArrayList<Alimento> alimentos = new ArrayList<>();
        alimentos.add(lentejas);
        alimentos.add(fideos);
        alimentos.add(salsaTomate);
        alimentos.add(panDeMolde);
        alimentos.add(arroz);

        Dieta dieta = new Dieta(alimentos);


        Ejercicio burpees = new Ejercicio("Burpees", 10,60,14.3f);
        Ejercicio flexiones = new Ejercicio("Flexiones", 12, 40, 8);
        Ejercicio sentadillas = new Ejercicio("Sentadillas", 10, 30, 9.8f);
        Ejercicio abdominales = new Ejercicio("Abdominales", 20, 40, 9.8f);

        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(burpees);
        ejercicios.add(flexiones);
        ejercicios.add(sentadillas);
        ejercicios.add(abdominales);

        Rutina rutina = new Rutina(ejercicios, 5);

        Date fechaNacimiento = new Date(2013,1,23);
        Date fechaIngreso = new Date(2022,8,31);

        Usuario usuario = new Usuario("Jose Urbina","43.567.234-4", fechaNacimiento,fechaIngreso,10);
        EstadoFisico estadoFisicoActual = new EstadoFisico(23.8f,1.32f,90.6f);
    }
}

