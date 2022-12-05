package GUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Alimentacion.Dieta;
import DatosUsuario.Credencial;
import Alimentacion.Alimento;
import Ejercitacion.Ejercicio;
import Ejercitacion.Rutina;
public class menuAdmin {

    public menuAdmin(){
        System.out.println("Bienvenido!");
        int opcion = -1;
        Scanner dato = new Scanner(System.in);
        while (opcion != 0){
            System.out.println("1. Cambiar Usuario y contreseña");
            System.out.println("2. Buscar Alimento");
            System.out.println("3. Crear Alimento");
            System.out.println("4. Eliminar ejercicio");
            System.out.println("5. Mostrar Alimentos");
            System.out.println("6. Modificar Ejercicio");
            System.out.println("7. Checkear si rutina existe");
            System.out.println("0. Cerrar programa");
            System.out.println("Registre opcion deseada:");
            opcion = dato.nextInt();

            switch (opcion){
                case 1 ->{
                    System.out.println("Ingrese usuario:");
                    String user = dato.next();
                    System.out.println("Ingrese contraseña:");
                    String pass = dato.next();
                    try {
                        Credencial.registrarCredencial(user,pass);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2 ->{
                    ArrayList<Alimento>alimentos = null;
                    try {
                        alimentos = Alimento.leerAlimentosDisponibles();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ingrese el alimento buscado");
                    String alimentoBuscado = dato.next();
                    Alimento alimentoBuscar = Alimento.buscarAlimento(alimentos,alimentoBuscado);



                }
                case 3 ->{
                    Alimento.obtenerAlimento();
                }
                case 4 ->{
                    String nombre = dato.next();
                    int repeticiones = dato.nextInt();
                    int duracionEstimada = dato.nextInt();
                    float calorias = dato.nextFloat();

                    Ejercicio ejercicio = new Ejercicio(nombre,repeticiones,duracionEstimada,calorias);

                    ArrayList<Ejercicio> ejercicios = null;
                    try {
                         ejercicios = Ejercicio.leerEjerciciosDisponibles();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        Ejercicio.eliminarEjerciciosDisponible(ejercicios,ejercicio);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
                case 5 ->{
                    ArrayList<Alimento> alimentos = null;
                    try {
                        alimentos = Alimento.leerAlimentosDisponibles();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    Alimento.mostrarAlimentosDisponibles(alimentos);
                }
                case 6 -> {
                    Ejercicio ejercicio = null;
                    ejercicio = Ejercicio.obtenerEjercicio();
                    ArrayList<Ejercicio> arr = null;
                    try {
                        arr = Ejercicio.leerEjerciciosDisponibles();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Ejercicio.modificarEjercicio(arr,ejercicio);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Ejercicio modificado correctamente");

                }
                case 7 ->{
                    try {
                        if(Rutina.existeRutina()){
                            System.out.println("Rutina existe en archivo");
                            System.out.println("Ubicado en: \\Recursos\\RecomendacionUsuario\\Rutina.txt");
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }


                }
                case 0 ->{
                    System.out.println("Adios :)");
                    System.exit(0);
                }
                default ->{
                }
            }
        }

    }
}
