package Alimentacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Alimento {
    //atributos
    private String nombre;
    private String tipo;
    private int cantidadEnGramos; //gramos que constituyen una porción
    private float energia;
    private float proteinas;
    private float grasas;
    private float azucares;
    private float sodio;

    //builder
    public Alimento (String nombre, String tipo, int cantidadEnGramos, float energia, float proteinas, float grasas, float azucares, float sodio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadEnGramos = cantidadEnGramos;
        this.energia = energia;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.azucares = azucares;
        this.sodio = sodio;
    }

    //setters and getters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCantidadEnGramos(int cantidadEnGramos) {
        this.cantidadEnGramos = cantidadEnGramos;
    }
    public void setEnergia(float energia) {
        this.energia = energia;
    }
    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }
    public void setSodio(float sodio) {
        this.sodio = sodio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadEnGramos() {
        return cantidadEnGramos;
    }
    public float getEnergia() {
        return energia;
    }
    public float getProteinas() {
        return proteinas;
    }
    public float getGrasas() {
        return grasas;
    }
    public float getAzucar() {
        return azucares;
    }
    public float getSodio() {
        return sodio;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }
    public float getAzucares() {
        return azucares;
    }
    public void setAzucares(float azucares) {
        this.azucares = azucares;
    }

    //METODOS
    public static ArrayList<Alimento> leerAlimentosDisponibles() throws FileNotFoundException {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        int cantidadAtributos = 8;
        String[] atributosAgregar = new String[cantidadAtributos];
        String filePath = new File("").getAbsolutePath(), componentesLinea;
        File archivoAlimentos = new File(filePath + "\\Recursos\\ElementosDisponibles\\AlimentosDisponibles.txt");
        Scanner scannerAlimentos = new Scanner(archivoAlimentos);
        while (scannerAlimentos.hasNextLine()) {
            for (int i = 0; i < cantidadAtributos; i++) {
                componentesLinea = scannerAlimentos.nextLine();
                if (componentesLinea.contains(":")) {
                    atributosAgregar[i] = componentesLinea.split(":")[1];
                }
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

    //agregar alimento a la lista de alimentos disponibles
    public static void agregarAlimentoDisponible(ArrayList<Alimento> alimentosDisponibles, Alimento alimentoAgregar) throws IOException {
        alimentosDisponibles.add(alimentoAgregar);
        reescribirAlimentosDisponibles(alimentosDisponibles);
    }

    //eliminar alimento disponible
    public static void eliminarAlimentoDisponible(ArrayList<Alimento> alimentos, Alimento alimentoEliminar) throws IOException {
        alimentos.remove(alimentoEliminar);
        reescribirAlimentosDisponibles(alimentos);
    }

    //mostrar alimentos disponibles por pantalla
    public static void mostrarAlimentosDisponibles(ArrayList<Alimento> alimentos) {
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

    //rescribir alimentos disponibles
    public static void reescribirAlimentosDisponibles(ArrayList<Alimento> alimentos) throws IOException {
        String filePath = new File("").getAbsolutePath();
        File archivoAlimentos = new File(filePath + "\\Recursos\\ElementosDisponibles\\AlimentosDisponibles.txt");
        FileWriter writer = new FileWriter(archivoAlimentos);
        for (Alimento alimento :
                alimentos) {
            writer.write("Nombre:" + alimento.getNombre() + "\n");
            writer.write("Tipo:" + alimento.getTipo() + "\n");
            writer.write("GramosPorcion:" + alimento.getCantidadEnGramos() + "\n");
            writer.write("Energia:" + alimento.getEnergia() + "\n");
            writer.write("Proteinas:" + alimento.getProteinas() + "\n");
            writer.write("Grasas:" + alimento.getGrasas() + "\n");
            writer.write("Azucares:" + alimento.getAzucar() + "\n");
            writer.write("Sodio:" + alimento.getSodio() + "\n");
        }
        writer.close();
    }

    //obtener alimento desde la consola
    public static Alimento obtenerAlimento() {
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

    //buscar alimento en alimentos disponibles, puede ser por nombre directamente o por nombre desde un objeto
    public static Alimento buscarAlimento(ArrayList<Alimento> alimentos, Alimento alimentoBuscar) {
        for (Alimento alimento :
                alimentos) {
            if (alimento.getNombre().equals(alimentoBuscar.getNombre())) {
                return alimento;
            }
        }
        return null;
    }
    public static Alimento buscarAlimento(ArrayList<Alimento> alimentos, String nombreAlimentoBuscar) {
        for (Alimento alimento :
                alimentos) {
            if (nombreAlimentoBuscar.equals(alimento.getNombre())) {
                return alimento;
            }
        }
        return null;
    }

    //actualizar elemento, puede ser por nombre directamente o por nombre desde un objeto
    public static void modificarAlimento(ArrayList<Alimento> alimentos, Alimento alimentoModificar) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < alimentos.size(); index++) {
            if (alimentos.get(index).getNombre().equals(alimentoModificar.getNombre())) {
                System.out.println("Ingrese el nuevo nombre del alimento: ");
                alimentos.get(index).setNombre(scanner.nextLine());
                System.out.println("Ingrese el nuevo tipo del alimento: ");
                alimentos.get(index).setTipo(scanner.nextLine());
                System.out.println("Ingrese la nueva cantidad de gramos que constituyen una porcion: ");
                alimentos.get(index).setCantidadEnGramos(scanner.nextInt());
                System.out.println("Ingrese la nueva cantidad de energia total: ");
                alimentos.get(index).setEnergia(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de proteina total: ");
                alimentos.get(index).setProteinas(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de grasas totales: ");
                alimentos.get(index).setGrasas(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de azucares totales: ");
                alimentos.get(index).setAzucares(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de sodio total: ");
                alimentos.get(index).setSodio(scanner.nextFloat());
            }
        }
        reescribirAlimentosDisponibles(alimentos);
    }

    public static void modificarAlimento(ArrayList<Alimento> alimentos, String nombreAlimentoModificar) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < alimentos.size(); index++) {
            if (alimentos.get(index).getNombre().equals(nombreAlimentoModificar)) {
                System.out.println("Ingrese el nuevo nombre del alimento: ");
                alimentos.get(index).setNombre(scanner.nextLine());
                System.out.println("Ingrese el nuevo tipo del alimento: ");
                alimentos.get(index).setTipo(scanner.nextLine());
                System.out.println("Ingrese la nueva cantidad de gramos que constituyen una porcion: ");
                alimentos.get(index).setCantidadEnGramos(scanner.nextInt());
                System.out.println("Ingrese la nueva cantidad de energia total: ");
                alimentos.get(index).setEnergia(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de proteina total: ");
                alimentos.get(index).setProteinas(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de grasas totales: ");
                alimentos.get(index).setGrasas(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de azucares totales: ");
                alimentos.get(index).setAzucares(scanner.nextFloat());
                System.out.println("Ingrese la nueva cantidad de sodio total: ");
                alimentos.get(index).setSodio(scanner.nextFloat());
            }
        }
        reescribirAlimentosDisponibles(alimentos);
    }
}
