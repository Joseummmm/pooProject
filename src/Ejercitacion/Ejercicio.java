package Ejercitacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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

    //METODOS
    public static ArrayList<Ejercicio> leerEjerciciosDisponibles() throws FileNotFoundException {
        ArrayList<Ejercicio> ejercicios = new ArrayList<>();
        int cantidadAtributos = 4;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath();
        File archivoEjercicios = new File(filePath + "\\Recursos\\ElementosDisponibles\\EjerciciosDisponibles.txt");
        Scanner scannerEjercicios = new Scanner(archivoEjercicios);
        while (scannerEjercicios.hasNextLine()) {
            for (int i = 0; i < cantidadAtributos; i++) {
                atributosAgregar[i] = scannerEjercicios.nextLine().split(":")[1];
            }
            Ejercicio ejercicioAgregar = new Ejercicio(atributosAgregar[0], Integer.parseInt(atributosAgregar[1]),
                    Integer.parseInt(atributosAgregar[2]),Float.parseFloat(atributosAgregar[3]));
            ejercicios.add(ejercicioAgregar);
        }
        scannerEjercicios.close();
        return ejercicios;
    }
}
