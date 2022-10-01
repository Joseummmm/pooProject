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
        ArrayList<Alimento> alimentosDisponibles = new ArrayList<>();
        ArrayList<Ejercicio> ejerciciosDisponibles = new ArrayList<>();
        leerAlimentosDisponibles(alimentosDisponibles);
        leerEjerciciosDisponibles(ejerciciosDisponibles);
        Usuario usuario;
        if (!existeUsuario()) {
            //FALTA ESCRIBIR CASO DONDE EXISTE EL USUARIO
            usuario = obtenerUsuario();
            escribirDatosUsuario(usuario);
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
        scannerAlimentos.close();
    }

    public static void escribirDatosUsuario(Usuario usuarioEscribir) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario.txt");
        FileWriter writer = new FileWriter(archivoUsuario);
        writer.write("Nombre:" + usuarioEscribir.getNombre());
        writer.write("Rut:" + usuarioEscribir.getRut());
        writer.write("FechaNacimiento:" + usuarioEscribir.getFechaNacimiento());
        writer.write("FechaIngreso:" + usuarioEscribir.getFechaIngreso());
        writer.write("Edad:" + usuarioEscribir.getEdad());
        writer.write("IMC:" + usuarioEscribir.getEstadoFisico().getIMC());
        writer.write("Altura:" + usuarioEscribir.getEstadoFisico().getAltura());
        writer.write("Peso:" + usuarioEscribir.getEstadoFisico().getPeso());
        //ESCRIBIR ESTADO FISICO
        writer.close();
    }

    public static Usuario obtenerUsuario() {
        Usuario usuario = new Usuario();
        Scanner scanner = new Scanner(System.in);
        LocalDateTime hoy = LocalDateTime.now();
        System.out.println("Ingrese su nombre: ");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Ingrese su rut: ");
        usuario.setRut(scanner.nextLine());
        System.out.println("Ingrese su fecha de nacimiento (DD//MM//AA): ");
        usuario.setFechaNacimiento(scanner.nextLine());
        usuario.setFechaIngreso(hoy.getDayOfMonth() + String.valueOf(hoy.getMonthValue()) +
                hoy.getYear());
        return usuario;
    }

    public static boolean existeUsuario() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\Usuario.txt");
        Scanner scanner = new Scanner(archivoUsuario);
        return Integer.parseInt(scanner.nextLine().split(":")[1]) == 1;
    }
}

