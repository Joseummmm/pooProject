package GUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import DatosUsuario.Credencial;
import Alimentacion.Alimento;
import Ejercitacion.Ejercicio;
public class menuRepresentativo {

    public menuRepresentativo(){
        System.out.println("Bienvenido!");
        int opcion = -1;
        Scanner dato = new Scanner(System.in);
        while (opcion != 0){
            System.out.println("1. Cambiar Usuario y contreseña");
            System.out.println("2. Buscar Alimento");
            System.out.println("3. Crear Alimento");
            System.out.println("4. Eliminar x");
            System.out.println("5. Mostrar Alimentos");
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

                default ->{
                }
            }
        }
        System.out.println("Adios :)");
    }
}
