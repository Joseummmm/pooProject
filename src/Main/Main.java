package Main;

import Alimentacion.Alimento;
import Alimentacion.Dieta;
import DatosUsuario.Usuario;
import Ejercitacion.Ejercicio;
import Ejercitacion.Rutina;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Alimento> alimentosDisponibles = Alimento.leerAlimentosDisponibles();
        ArrayList<Ejercicio> ejerciciosDisponibles = Ejercicio.leerEjerciciosDisponibles();
        Usuario usuario;
        //establecer datos del objeto usuario dependiendo de si ya existe o no
        if (Usuario.existeUsuario()) {
            System.out.println("Existe1");
            usuario = Usuario.leerUsuario();
            usuario.setRutinaRecomendada(Rutina.leerRutina(ejerciciosDisponibles));
            usuario.setDietaRecomendada(Dieta.leerDieta(alimentosDisponibles));
        } else {
            usuario = Usuario.obtenerUsuario();
            Usuario.escribirDatosUsuario(usuario);
        }
    }

    //ALIMENTOS
    //obtener alimento desde la consola
    private static Alimento obtenerAlimento() {
        Scanner scanner = new Scanner(System.in);
        String nombre,tipo;
        int cantidadEnGramos;
        float energia,proteinas,grasas,azucares,sodio;
        System.out.println("Ingrese el nombre del alimento: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el tipo de alimento: ");
        tipo = scanner.nextLine();
        System.out.println("Ingrese la energia total del alimento: ");
        energia = scanner.nextFloat();
        System.out.println("Ingrese la proteina total del alimento: ");
        proteinas = scanner.nextFloat();
        System.out.println("Ingrese las grasas totales del alimento: ");
        grasas = scanner.nextFloat();
        System.out.println("Ingrese el azucar total del alimento: ");
        azucares = scanner.nextFloat();
        System.out.println("Ingrese el sodio total del alimento: ");
        sodio = scanner.nextFloat();
        System.out.println("Ingrese la cantidad de gramos que constituyen una porcion del alimento: ");
        cantidadEnGramos = scanner.nextInt();
        return new Alimento(nombre,tipo,cantidadEnGramos,energia,proteinas,grasas,azucares,sodio);
    }
    //agregar alimento a la lista de alimentos dispoinbles
    private static void agregarAlimentoDisponible(Alimento alimento) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoAlimentos = new File(filePath + "\\Recursos\\ElementosDisponibles\\AlimentosDisponibles.txt");
        FileWriter writer = new FileWriter(archivoAlimentos, true);
        writer.write("Nombre:" + alimento.getNombre() + "\n");
        writer.write("Tipo:" + alimento.getTipo() + "\n");
        writer.write("GramosPorcion:" + alimento.getCantidadEnGramos() + "\n");
        writer.write("Energia:" + alimento.getEnergia() + "\n");
        writer.write("Proteinas:" + alimento.getProteinas() + "\n");
        writer.write("Grasas:" + alimento.getGrasas() + "\n");
        writer.write("Azucares:" + alimento.getAzucar() + "\n");
        writer.write("Sodio:" + alimento.getSodio() + "\n");
        writer.close();
    }
    //mostrar alimentos disponibles por pantalla
    private static void mostrarAlimentosDisponibles(ArrayList<Alimento> alimentos) {
        for (Alimento x :
                alimentos) {
            System.out.println("Nombre: " + x.getNombre());
            System.out.println("Tipo de alimento: " + x.getTipo());
            System.out.println("Gramos por porcion: " + x.getCantidadEnGramos());
            System.out.println("Energia total: " + x.getEnergia());
            System.out.println("Proteina total: " + x.getProteinas());
            System.out.println("Grasas totales: " + x.getGrasas());
            System.out.println("Azucares totales: " + x.getAzucar());
            System.out.println("Sodio total: " + x.getSodio());
            System.out.println();
        }
    }

    //EJERCICIO
    //obtener ejercicio desde la consola
    private static Ejercicio obtenerEjercicio() {
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
    private static void agregarEjercicioDisponible(Ejercicio ejercicio) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoEjercicios = new File(filePath + "\\Recursos\\ElementosDisponibles\\EjerciciosDisponibles.txt");
        FileWriter writer = new FileWriter(archivoEjercicios, true);
        writer.write("Nombre:" + ejercicio.getNombre() + "\n");
        writer.write("Repeticiones:" + ejercicio.getRepeticiones() + "\n");
        writer.write("DuracionEstimada:" + ejercicio.getDuracionEstimada() + "\n");
        writer.write("CaloriasQuemadasPorMinuto:" + ejercicio.getCaloriasQuemadasPorMinuto() + "\n");
        writer.close();
    }
    //mostrar ejercicios disponibles
    private static void mostrarEjerciciosDisponibles(ArrayList<Ejercicio> ejercicios) {
        for (Ejercicio x :
                ejercicios) {
            System.out.println("Nombre: " + x.getNombre());
            System.out.println("Repeticiones: " + x.getRepeticiones());
            System.out.println("Duracion estimada: " + x.getDuracionEstimada());
            System.out.println("Calorias quemadas por minuto: " + x.getCaloriasQuemadasPorMinuto());
            System.out.println();
        }
    }


}

