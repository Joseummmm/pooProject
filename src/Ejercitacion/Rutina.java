package Ejercitacion;

import Ejercitacion.Ejercicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rutina {
    //atributos
    private ArrayList<Ejercicio> ejercicios;
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

    public Rutina() {}
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

    //METODOS
    public static boolean existeRutina() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Rutina.txt");
        Scanner scanner = new Scanner(archivoUsuario);
        return Integer.parseInt(scanner.nextLine().split(":")[1]) == 1;
    }
    public static void escribirRutina(Rutina rutina) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoRutina = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Rutina.txt");
        FileWriter writer = new FileWriter(archivoRutina);
        writer.write("existe:1\n");
        writer.write("ejercicios:");
        for (Ejercicio e : rutina.getEjercicios()) {
            writer.write(e.getNombre() + "-");
        }

        writer.write("\n");
        writer.write("TiempoEstimado:" + rutina.getTiempoEstimado() + "\n");
        writer.write("Series:" + rutina.getSeries() + "\n");

        writer.close();
    }
    public static Ejercicio obtenerEjercicioPorNombre(String nombre, ArrayList<Ejercicio> ejerciciosDisponibles) {
        for (Ejercicio e : ejerciciosDisponibles) {
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;
    }
    public static Rutina leerRutina(ArrayList<Ejercicio> ejerciciosDisponibles) throws FileNotFoundException {
        Rutina rutinaDevolver = new Rutina();
        ArrayList<Ejercicio> ejerciciosEstablecer = new ArrayList<>();
        String filePath = new File("").getAbsolutePath(), componentesLinea;
        File archivoRutina = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Rutina.txt");
        Scanner scannerRutina = new Scanner(archivoRutina);
        int cantLineas = 4;
        String[] atributos = new String[cantLineas-1]; //-1 para no contar el existe del inicio
        scannerRutina.nextLine();
        for (int i = 0; i < cantLineas && scannerRutina.hasNextLine(); i++) {
            componentesLinea = scannerRutina.nextLine();
            if (componentesLinea.contains(":")) {
                atributos[i] = componentesLinea.split(":")[1];
            }
        }
        scannerRutina.close();

        for (String ejercicio : atributos[0].split("-")) {
            if (obtenerEjercicioPorNombre(ejercicio, ejerciciosDisponibles) != null) {
                ejerciciosEstablecer.add(obtenerEjercicioPorNombre(ejercicio,ejerciciosDisponibles));
            }
        }
        rutinaDevolver.setEjercicios(ejerciciosEstablecer);
        rutinaDevolver.setTiempoEstimado(Integer.parseInt(atributos[1]));
        rutinaDevolver.setSeries(Integer.parseInt(atributos[2]));

        return rutinaDevolver;
    }
    public void imprimirRutina() {
        System.out.println("----RUTINA----");
        System.out.println("Tiempo estimado: " + tiempoEstimado);
        for (Ejercicio ejercicio : getEjercicios()) {
            System.out.println();
            System.out.println("Nombre: " + ejercicio.getNombre());
            System.out.println("Repeticiones: " + ejercicio.getRepeticiones());
            System.out.println("Duracion estimada: " + ejercicio.getDuracionEstimada());
            System.out.println("Calorias quemadas por minuto: " + ejercicio.getCaloriasQuemadasPorMinuto());
        }
    }
}
