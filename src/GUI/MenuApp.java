package GUI;

import DatosUsuario.Credencial;
import Ejercitacion.Ejercicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuApp {
    private JButton nuevoUsuarioYContraseñaButton;
    private JButton eliminarEjercicioButton;
    private JButton agegarAlimentoButton;
    private JButton mostrarAlimentosButton;
    private JButton crearAlimentoButton;
    private JButton cerrarProgramaButton;

    public MenuApp() {
        nuevoUsuarioYContraseñaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner dato = new Scanner(System.in);
                System.out.println("Ingrese usuario:");
                String user = dato.next();
                System.out.println("Ingrese contraseña:");
                String pass = dato.next();
                try {
                    Credencial.registrarCredencial(user,pass);
                } catch (IOException ea) {
                    throw new RuntimeException(ea);
                }
            }
        });

        eliminarEjercicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner dato = new Scanner(System.in);
                System.out.println("Ingrese nombre ejercicio:");
                String nombre = dato.next();
                System.out.println("Ingrese repeticiones ejercicio:");

                boolean catched = false;
                int repeticiones = -1;
                do{
                    catched = false;
                    dato.nextLine();
                    try {
                        repeticiones = dato.nextInt();
                    }catch (Exception po){
                        System.out.println("Formato incorrecto");
                        catched = true;
                    }
                } while (!catched);

                int duracionEstimada = -1;
                do{
                    catched = false;
                    dato.nextLine();
                    try {
                        duracionEstimada = dato.nextInt();
                    }catch (Exception po){
                        System.out.println("Formato incorrecto");
                        catched = true;
                    }
                } while (!catched);

                float calorias = -1;
                do{
                    catched = false;
                    dato.nextLine();
                    try {
                        calorias = dato.nextInt();
                    }catch (Exception po){
                        System.out.println("Formato incorrecto");
                        catched = true;
                    }
                } while (!catched);

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
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
