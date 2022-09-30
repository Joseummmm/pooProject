package com.company.poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Alimento> alimentosDisponibles = new ArrayList<>();
        ArrayList<Ejercicio> ejerciciosDisponibles = new ArrayList<>();
        leerAlimentosDisponibles(alimentosDisponibles);
        leerEjerciciosDisponibles(ejerciciosDisponibles);
        
        //MENU
        Scanner dato = new Scanner(System.in);
        int opcion = dato.nextInt();
        while (opcion != 4){
            switch(opcion)
            {
                case 1 -> {
                    Usuario user = new Usuario();
                }
                case 2 -> {
                    for (int i = 0;i<ejercicios.size();i++){
                        System.out.println(ejercicios.get(i).getNombre()+" "+ejercicios.get(i).getRepeticiones()+" "ejercicios.get(i).getDuracionEstimada()+" "ejercicios.get(i).getCaloriasQuemadasPorMinuto());
                    }
                }
                default -> System.out.println("Opcion invalida");
            }
            opcion = dato.nextInt();
        }
        
    }

    public static void leerAlimentosDisponibles(ArrayList<Alimento> alimentos) throws FileNotFoundException {
        int cantidadAtributos = 8;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath();
        File archivoAlimentos = new File(filePath + "\\Recursos\\Alimentos.txt");
        Scanner scannerAlimentos = new Scanner(archivoAlimentos);
        while (scannerAlimentos.hasNextLine()) {
            for (int i = 0; i < cantidadAtributos; i++) {
                atributosAgregar[i] = scannerAlimentos.nextLine().split(":")[1];
            }
            Alimento alimentoAgregar = new Alimento(atributosAgregar[0], atributosAgregar[1],
                    Integer.parseInt(atributosAgregar[2]),Float.parseFloat(atributosAgregar[3]),
                    Float.parseFloat(atributosAgregar[4]), Float.parseFloat(atributosAgregar[5]),
                    Float.parseFloat(atributosAgregar[6]), Float.parseFloat(atributosAgregar[7]));
            alimentos.add(alimentoAgregar);
        }
    }

    public static void leerEjerciciosDisponibles(ArrayList<Ejercicio> ejercicios) throws FileNotFoundException {
        int cantidadAtributos = 4;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath();
        File archivoEjercicios = new File(filePath + "\\Recursos\\Ejercicios.txt");
        Scanner scannerAlimentos = new Scanner(archivoEjercicios);
        while (scannerAlimentos.hasNextLine()) {
            for (int i = 0; i < cantidadAtributos; i++) {
                atributosAgregar[i] = scannerAlimentos.nextLine().split(":")[1];
            }
            Ejercicio ejercicioAgregar = new Ejercicio(atributosAgregar[0], Integer.parseInt(atributosAgregar[1]),
                    Integer.parseInt(atributosAgregar[2]),Float.parseFloat(atributosAgregar[3]));
            ejercicios.add(ejercicioAgregar);
        }
    }
}

