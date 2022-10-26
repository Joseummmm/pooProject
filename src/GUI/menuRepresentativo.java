package GUI;
import java.io.IOException;
import java.util.Scanner;
import DatosUsuario.Credencial;
import Alimentacion.Alimento;
import Ejercitacion.Ejercicio;
public class menuRepresentativo {

    public menuRepresentativo(){
        System.out.println("Bienvenido!");
        int opcion = -1;
        Scanner dato = new Scanner(System.in);
        do{
            System.out.println("1. Cambiar Usuario y contreseña");
            System.out.println("2. Buscar Alimento");
            System.out.println("3. Crear Alimento");
            System.out.println("4. Eliminar ejercicio");
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

                }
                case 3 ->{

                }
                case 4 ->{

                }
                case 5 ->{

                }
                case 0 ->{
                    System.out.println("Adios :)");
                }
                default ->{
                }
            }
        }while (opcion != 0);
        System.exit(0);
    }
}
