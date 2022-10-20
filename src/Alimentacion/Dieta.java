package Alimentacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dieta {
    //atributos
    private ArrayList<Alimento> alimentosDieta;
    private float energiaTotal = 0;
    private float proteinaTotal = 0;
    private float grasaTotal = 0;
    private float azucarTotal = 0;
    private float sodioTotal = 0;

    //builder
    public Dieta (ArrayList<Alimento> alimentosDieta) {
        this.alimentosDieta = alimentosDieta;
        for (Alimento alimento:
                alimentosDieta) {
            energiaTotal += alimento.getEnergia();
            proteinaTotal += alimento.getProteinas();
            grasaTotal += alimento.getGrasas();
            azucarTotal += alimento.getAzucar();
            sodioTotal += alimento.getSodio();
        }
    }
    public Dieta () {}

    //getters and setters
    public ArrayList<Alimento> getAlimentosDieta() {
        return alimentosDieta;
    }
    public void setAlimentosDieta(ArrayList<Alimento> alimentosDieta) {
        this.alimentosDieta = alimentosDieta;
    }
    public float getEnergiaTotal() {
        return energiaTotal;
    }
    public float getProteinaTotal() {
        return proteinaTotal;
    }
    public float getGrasaTotal() {
        return grasaTotal;
    }
    public float getAzucarTotal() {
        return azucarTotal;
    }
    public float getSodioTotal() {
        return sodioTotal;
    }
    public void setEnergiaTotal(float energiaTotal) {
        this.energiaTotal = energiaTotal;
    }
    public void setProteinaTotal(float proteinaTotal) {
        this.proteinaTotal = proteinaTotal;
    }
    public void setGrasaTotal(float grasaTotal) {
        this.grasaTotal = grasaTotal;
    }
    public void setAzucarTotal(float azucarTotal) {
        this.azucarTotal = azucarTotal;
    }
    public void setSodioTotal(float sodio) {
        this.sodioTotal = sodio;
    }

    //METODOS
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
        for (Alimento alimento : dieta.getAlimentosDieta()) {
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
        scannerDieta.nextLine();
        for (int i = 0; i < cantLineas && scannerDieta.hasNextLine(); i++) {
            atributos[i] = scannerDieta.nextLine().split(":")[1];
        }
        scannerDieta.close();
        for (String alimento : atributos[0].split("-")) {
            if (obtenerAlimentoPorNombre(alimento, alimentosDisponibles) != null) {
                alimentosEstablecer.add(obtenerAlimentoPorNombre(alimento,alimentosDisponibles));
            }
        }
        dietaDevolver.setAlimentosDieta(alimentosEstablecer);
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

}
