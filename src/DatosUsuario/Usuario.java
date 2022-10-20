package DatosUsuario;

import Alimentacion.Dieta;
import Ejercitacion.Rutina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Usuario {
    //atributos
    private String nombre;
    private String rut;
    private String fechaNacimiento;
    private String fechaIngreso;
    private int edad;
    private EstadoFisico estadoFisico;
    private Rutina rutinaRecomendada;
    private Dieta dietaRecomendada;

    //builder
    public Usuario(String nombre, String rut, String fechaNacimiento, String fechaIngreso, int edad, EstadoFisico estadoFisico) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.edad = edad;
        this.estadoFisico = estadoFisico;
    }
    public Usuario() {}

    //getters and setters
    public String getNombre() {
        return this.nombre;
    }
    public String getRut() {
        return this.rut;
    }
    public int getEdad() {
        return this.edad;
    }
    public EstadoFisico getEstadoFisico() {
        return this.estadoFisico;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setEstadoFisico(EstadoFisico estadoFisico) {
        this.estadoFisico = estadoFisico;
    }
    public Rutina getRutinaRecomendada() {
        return rutinaRecomendada;
    }
    public void setRutinaRecomendada(Rutina rutinaRecomendada) {
        this.rutinaRecomendada = rutinaRecomendada;
    }
    public Dieta getDietaRecomendada() {
        return dietaRecomendada;
    }
    public void setDietaRecomendada(Dieta dietaRecomendada) {
        this.dietaRecomendada = dietaRecomendada;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    //METODOS
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
        int edad;
        float altura, peso;
        System.out.println("Ingrese su nombre: ");
        usuario.setNombre(scanner.nextLine());
        System.out.println("Ingrese su rut: ");
        usuario.setRut(scanner.nextLine());
        System.out.println("Ingrese su fecha de nacimiento (DD/MM/AA): ");
        usuario.setFechaNacimiento(scanner.nextLine());
        usuario.setFechaIngreso(hoy.getDayOfMonth() + "/" + hoy.getMonthValue() + "/" +
                hoy.getYear());
        System.out.println("Ingrese su altura (decimal separado con coma): ");
        altura = scanner.nextFloat();
        System.out.println("Ingrese su peso: ");
        peso = scanner.nextFloat();
        usuario.setEstadoFisico(new EstadoFisico(altura,peso));
        System.out.println("Ingrese su edad:");
        edad = scanner.nextInt();
        usuario.setEdad(edad);
        return usuario;
    }
    //comprobar si existe usuario
    public static boolean existeUsuario() throws FileNotFoundException {
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario\\DatosUsuario.txt");
        Scanner scanner = new Scanner(archivoUsuario);
        return Integer.parseInt(scanner.nextLine().split(":")[1]) == 1;
    }
    //obtener usuario desde entrada de texto
    public static Usuario leerUsuario() throws FileNotFoundException {
        Usuario usuarioReturn = new Usuario();
        EstadoFisico estadoEstablecer = new EstadoFisico();
        String filePath = new File("").getAbsolutePath();
        File archivoUsuario = new File(filePath + "\\Recursos\\DatosUsuario\\DatosUsuario.txt");
        Scanner scannerDatosUsuario = new Scanner(archivoUsuario);
        int cantLineas = 9;
        String[] atributos = new String[cantLineas-1]; //-1 para no contar el existe del inicio
        scannerDatosUsuario.nextLine();
        for (int i = 0; i < cantLineas; i++) {
            atributos[i] = scannerDatosUsuario.nextLine().split(":")[1];
        }
        for (String x:
                atributos) {
            System.out.println(x);
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
}
