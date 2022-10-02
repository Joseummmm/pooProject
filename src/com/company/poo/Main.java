package com.company.poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Alimento> alimentosDisponibles = leerAlimentosDisponibles();
        ArrayList<Ejercicio> ejerciciosDisponibles = leerEjerciciosDisponibles();
        Usuario usuario;
        if (existeUsuario()) {
            usuario = leerUsuario();
            usuario.setRutinaRecomendada(leerRutina(ejerciciosDisponibles));
            usuario.setDietaRecomendada(leerDieta(alimentosDisponibles));
        } else {
            usuario = obtenerUsuario();
            escribirDatosUsuario(usuario);
        }
        
    }

    //------USUARIO------
    //leer desde txt
    public static Usuario leerUsuario() throws FileNotFoundException {
        Usuario usuarioReturn = new Usuario();
        EstadoFisico estadoEstablecer = new EstadoFisico();
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario\\DatosUsuario.txt");
        Scanner scannerDatosUsuario = new Scanner(archivoUsuario);
        int cantLineas = 9;
        String[] atributos = new String[cantLineas-1]; //-1 para no contar el existe del inicio
        for (int i = 0; i < cantLineas; i++) {
            if (i != 0) {
                atributos[i-1] = scannerDatosUsuario.nextLine().split(":")[1];
            }
        }
        scannerDatosUsuario.close();
        usuarioReturn.setNombre(atributos[0]);
        usuarioReturn.setRut(atributos[1]);
        usuarioReturn.setFechaNacimiento(atributos[2]);
        usuarioReturn.setFechaIngreso(atributos[3]);
        usuarioReturn.setEdad(Integer.parseInt(atributos[4]));
        estadoEstablecer.setIMC(Float.parseFloat(atributos[5]));
        estadoEstablecer.setAltura(Float.parseFloat(atributos[6]));
        estadoEstablecer.setPeso(Float.parseFloat(atributos[7]));
        usuarioReturn.setEstadoFisico(estadoEstablecer);
        return usuarioReturn;
    }
    //escribir a un txt
    public static void escribirDatosUsuario(Usuario usuarioEscribir) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario\\DatosUsuario.txt");
        FileWriter writer = new FileWriter(archivoUsuario);
        writer.write("existe:1\n");
        writer.write("Nombre:" + usuarioEscribir.getNombre() + "\n");
        writer.write("Rut:" + usuarioEscribir.getRut() + "\n");
        writer.write("FechaNacimiento:" + usuarioEscribir.getFechaNacimiento() + "\n");
        writer.write("FechaIngreso:" + usuarioEscribir.getFechaIngreso() + "\n");
        writer.write("Edad:" + usuarioEscribir.getEdad() + "\n");
        writer.write("IMC:" + usuarioEscribir.getEstadoFisico().getIMC() + "\n");
        writer.write("Altura:" + usuarioEscribir.getEstadoFisico().getAltura() + "\n");
        writer.write("Peso:" + usuarioEscribir.getEstadoFisico().getPeso() + "\n");
        writer.close();
    }
    //leer desde entrada de consola
    public static Usuario obtenerUsuario() {
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now();
        float altura, peso;
        System.out.println("Ingrese su nombre: ");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Ingrese su rut: ");
        usuario.setRut(scanner.nextLine());
        System.out.println("Ingrese su fecha de nacimiento (DD//MM//AA): ");
        usuario.setFechaNacimiento(scanner.nextLine());
        usuario.setFechaIngreso(hoy.getDayOfMonth() + String.valueOf(hoy.getMonthValue()) +
                hoy.getYear());
        System.out.println("Ingrese su altura: ");
        altura = scanner.nextFloat();
        System.out.println("Ingrese su peso: ");
        peso = scanner.nextFloat();
        usuario.setEstadoFisico(new EstadoFisico(altura,peso));
        return usuario;
    }
    //comprobar si existe usuario
    public static boolean existeUsuario() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario\\DatosUsuario.txt");
        Scanner scanner = new Scanner(archivoUsuario);
        return Integer.parseInt(scanner.nextLine().split(":")[1]) == 1;
    }


    //------DATOS DISPONIBLES - EJERCICIOS - ALIMENTOS------
    public static ArrayList<Alimento> leerAlimentosDisponibles() throws FileNotFoundException {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        int cantidadAtributos = 8;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath();
        File archivoAlimentos = new File(filePath + "\\Recursos\\ElementosDisponibles\\AlimentosDisponibles.txt");
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
        scannerAlimentos.close();
        return alimentos;
    }
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


    //------DIETA------
    public static boolean existeDieta() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Dieta.txt");
        Scanner scanner = new Scanner(archivoUsuario);
        return Integer.parseInt(scanner.nextLine().split(":")[1]) == 1;
    }
    public static void escribirDieta(Dieta dieta) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoDieta = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Dieta.txt");
        FileWriter writer = new FileWriter(archivoDieta);
        writer.write("existe:1\n");
        writer.write("alimentos:");
        for (Alimento alimento : dieta.getAlimentos()) {
            writer.write(alimento.getNombre() + "-");
        }

        writer.write("\n");
        writer.write("EnergiaTotal:" + dieta.getEnergiaTotal() + "\n");
        writer.write("ProteinaTotal:" + dieta.getProteinaTotal() + "\n");
        writer.write("GrasaTotal:" + dieta.getGrasaTotal() + "\n");
        writer.write("AzucarTotal:" + dieta.getGrasaTotal() + "\n");
        writer.write("SodioTotal:" + dieta.getSodioTotal() + "\n");

        writer.close();
    }
    public static Dieta leerDieta(ArrayList<Alimento> alimentosDisponibles) throws FileNotFoundException {
        Dieta dietaDevolver = new Dieta();
        ArrayList<Alimento> alimentosEstablecer = new ArrayList<>();
        String filePath = new File("").getAbsolutePath();
        File archivoDieta = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Dieta.txt");
        Scanner scannerDieta = new Scanner(archivoDieta);
        int cantLineas = 7;
        String[] atributos = new String[cantLineas-1]; //-1 para no contar el existe del inicio
        for (int i = 0; i < cantLineas; i++) {
            if (i != 0) {
                atributos[i-1] = scannerDieta.nextLine().split(":")[1];
            }
        }
        scannerDieta.close();
        for (String alimento : atributos[0].split("-")) {
            if (obtenerAlimentoPorNombre(alimento, alimentosDisponibles) != null) {
                alimentosEstablecer.add(obtenerAlimentoPorNombre(alimento,alimentosDisponibles));
            }
        }
        dietaDevolver.setAlimentos(alimentosEstablecer);
        dietaDevolver.setEnergiaTotal(Float.parseFloat(atributos[1]));
        dietaDevolver.setProteinaTotal(Float.parseFloat(atributos[2]));
        dietaDevolver.setGrasaTotal(Float.parseFloat(atributos[3]));
        dietaDevolver.setAzucarTotal(Float.parseFloat(atributos[4]));
        dietaDevolver.setSodioTotal(Float.parseFloat(atributos[5]));
        return dietaDevolver;
    }
    public static Alimento obtenerAlimentoPorNombre(String nombre, ArrayList<Alimento> alimentosDisponibles) {
        for (Alimento a : alimentosDisponibles) {
            if (a.getNombre().equals(nombre)) {
                return a;
            }
        }
        return null;
    }

    //------RUTINA------
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
        String filePath = new File("").getAbsolutePath();
        File archivoRutina = new File(filePath + "\\Recursos\\RecomendacionUsuario\\Rutina.txt");
        Scanner scannerRutina = new Scanner(archivoRutina);
        int cantLineas = 4;
        String[] atributos = new String[cantLineas-1]; //-1 para no contar el existe del inicio
        for (int i = 0; i < cantLineas; i++) {
            if (i != 0) {
                atributos[i-1] = scannerRutina.nextLine().split(":")[1];
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

}

