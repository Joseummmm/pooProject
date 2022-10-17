package Ejercitacion;

import Alimentacion.Alimento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    public void setCaloriasQuemadasPorMinuto(float caloriasQuemadasPorMinuto) {
        this.caloriasQuemadasPorMinuto = caloriasQuemadasPorMinuto;
    }
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
    //leer ejercicios desde archivo de texto
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
    //obtener ejercicio desde la consola
    public static Ejercicio obtenerEjercicio() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int repeticiones, duracionEstimada;
        float caloriasQuemadasPorMinuto;
        System.out.println("Ingrese el nombre del ejercicio: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el numero de repeticiones estandar del ejercicio: ");
        repeticiones = scanner.nextInt();
        System.out.println("Ingrese la cantidad de minutos que dura aproximadamente el ejercicio: ");
        duracionEstimada = scanner.nextInt();
        System.out.println("Ingrese la cantidad habitual de calorias quemadas por minuto: ");
        caloriasQuemadasPorMinuto = scanner.nextFloat();
        return new Ejercicio(nombre,repeticiones,duracionEstimada,caloriasQuemadasPorMinuto);
    }
    //agregar ejercicio a lista de ejercicios disponibles
    public static void agregarEjercicioDisponible(ArrayList<Ejercicio> ejercicios, Ejercicio ejercicioAgregar) throws IOException {
        ejercicios.add(ejercicioAgregar);
        reescribirEjerciciosDisponibles(ejercicios);
    }
    //eliminar alimento disponible
    public static void eliminarEjerciciosDisponible(ArrayList<Ejercicio> ejercicios, Ejercicio ejercicioEliminar) throws IOException {
        ejercicios.remove(ejercicioEliminar);
        reescribirEjerciciosDisponibles(ejercicios);
    }
    //mostrar ejercicios disponibles
    public static void mostrarEjerciciosDisponibles(ArrayList<Ejercicio> ejercicios) {
        for (Ejercicio x :
                ejercicios) {
            System.out.println("Nombre: " + x.getNombre());
            System.out.println("Repeticiones: " + x.getRepeticiones());
            System.out.println("Duracion estimada: " + x.getDuracionEstimada());
            System.out.println("Calorias quemadas por minuto: " + x.getCaloriasQuemadasPorMinuto());
            System.out.println();
        }
    }
    //reescribir alimentos disponibles
    public static void reescribirEjerciciosDisponibles(ArrayList<Ejercicio> ejercicios) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoEjercicios = new File(filePath + "\\Recursos\\ElementosDisponibles\\EjerciciosDisponibles.txt");
        FileWriter writer = new FileWriter(archivoEjercicios);
        for (Ejercicio ejercicio :
                ejercicios) {
            writer.write("Nombre:" + ejercicio.getNombre() + "\n");
            writer.write("Repeticiones:" + ejercicio.getRepeticiones() + "\n");
            writer.write("DuracionEstimada:" + ejercicio.getDuracionEstimada() + "\n");
            writer.write("CaloriasQuemadasPorMinuto:" + ejercicio.getCaloriasQuemadasPorMinuto() + "\n");
        }
        writer.close();
    }
    //buscar ejercicio desde los ejercicios disponibles, puede ser por nombre directamente o por nombre desde un objeto
    public static Ejercicio buscarEjercicio(ArrayList<Ejercicio> ejercicios, Ejercicio ejercicioBuscar) {
        for (Ejercicio ejercicio :
            ejercicios) {
            if (ejercicio.getNombre().equals(ejercicioBuscar.getNombre())) {
                return ejercicio;
            }
        }
        return null;
    }
    public static Ejercicio buscarEjercicio(ArrayList<Ejercicio> ejercicios, String nombreEjercicioBuscar) {
        for (Ejercicio ejercicio :
                ejercicios) {
            if (ejercicio.getNombre().equals(nombreEjercicioBuscar)) {
                return ejercicio;
            }
        }
        return null;
    }
    //modificar ejercicio, puede ser por nombre directamente o por nombre desde un objeto
    public static void modificarEjercicio(ArrayList<Ejercicio> ejercicios, Ejercicio ejercicioModificar) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < ejercicios.size(); index++) {
            if (ejercicios.get(index).getNombre().equals(ejercicioModificar.getNombre())) {
                System.out.println("Ingrese el nuevo nombre del ejercicio: ");
                ejercicios.get(index).setNombre(scanner.nextLine());
                System.out.println("Ingrese el numero de repeticiones para el ejercicio: ");
                ejercicios.get(index).setRepeticiones(scanner.nextInt());
                System.out.println("Ingrese la nueva duracion estimada del ejercicio: ");
                ejercicios.get(index).setDuracionEstimada(scanner.nextInt());
                System.out.println("Ingrese la nueva cantidad de calorias quemadas por minuto: ");
                ejercicios.get(index).setCaloriasQuemadasPorMinuto(scanner.nextFloat());
            }
        }
        reescribirEjerciciosDisponibles(ejercicios);
    }
    public static void modificarEjercicio(ArrayList<Ejercicio> ejercicios, String nombreEjercicioModificar) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < ejercicios.size(); index++) {
            if (ejercicios.get(index).getNombre().equals(nombreEjercicioModificar)) {
                System.out.println("Ingrese el nuevo nombre del ejercicio: ");
                ejercicios.get(index).setNombre(scanner.nextLine());
                System.out.println("Ingrese el numero de repeticiones para el ejercicio: ");
                ejercicios.get(index).setRepeticiones(scanner.nextInt());
                System.out.println("Ingrese la nueva duracion estimada del ejercicio: ");
                ejercicios.get(index).setDuracionEstimada(scanner.nextInt());
                System.out.println("Ingrese la nueva cantidad de calorias quemadas por minuto: ");
                ejercicios.get(index).setCaloriasQuemadasPorMinuto(scanner.nextFloat());
            }
        }
        reescribirEjerciciosDisponibles(ejercicios);
    }
}
