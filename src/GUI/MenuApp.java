package GUI;

import Alimentacion.Alimento;
import Alimentacion.Dieta;
import DatosUsuario.Credencial;
import Ejercitacion.Ejercicio;
import Ejercitacion.Rutina;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuApp {
    private JButton nuevoUserYPass;
    private JButton buscarAlimentoButton;
    private JButton mostrarAlimentosButton;
    private JButton MostrarEjerciciosEnRango;
    private JButton cerrarProgramaButton;
    private JButton mostrarDieta;
    private JButton mostrarRutina;
    private JFrame frame;
    private JPanel panel;
    public MenuApp() {

        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(400,500);
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        nuevoUserYPass = new JButton("Nuevo User Y Pass");
        nuevoUserYPass.setBounds(20,20,80,25);
        panel.add(nuevoUserYPass);


        buscarAlimentoButton = new JButton("buscar alimento");
        buscarAlimentoButton.setBounds(240,20,80,25);
        panel.add(buscarAlimentoButton);

        mostrarAlimentosButton = new JButton("Mostrar alimentos por consola");
        mostrarAlimentosButton.setBounds(20,60,80,25);
        panel.add(mostrarAlimentosButton);


        MostrarEjerciciosEnRango = new JButton("Mostrar ejercicios en rango");
        panel.add(MostrarEjerciciosEnRango);

        mostrarDieta = new JButton("Mostrar Dieta");
        panel.add(mostrarDieta);

        mostrarRutina = new JButton("Mostrar Rutina");
        panel.add(mostrarRutina);

        cerrarProgramaButton = new JButton("Cerrar programa");
        cerrarProgramaButton.setBounds(240,60,80,25);
        panel.add(cerrarProgramaButton);


        frame.setVisible(true);

        mostrarRutina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Ejercicio> array = null;
                try {
                    array = Ejercicio.leerEjerciciosDisponibles();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Rutina rutina = new Rutina();
                rutina.setEjercicios(array);
                rutina.imprimirRutina();
            }
        });
        mostrarDieta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Alimento> alimentos = null;
                try {
                    alimentos = Alimento.leerAlimentosDisponibles();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Dieta dieta = new Dieta(alimentos);
                dieta.imprimirDieta();
            }
        });
        nuevoUserYPass.addActionListener(new ActionListener() {
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
                System.out.println("User y pass actualizadas correctamente");
            }
        });


        mostrarAlimentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Alimento> alimentos = null;
                try {
                    alimentos = Alimento.leerAlimentosDisponibles();
                } catch (FileNotFoundException op) {
                    throw new RuntimeException(op);
                }
                Alimento.mostrarAlimentosDisponibles(alimentos);
            }
        });

        cerrarProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buscarAlimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner dato = new Scanner(System.in);
                ArrayList<Alimento>alimentos = null;
                try {
                    alimentos = Alimento.leerAlimentosDisponibles();
                } catch (FileNotFoundException a) {
                    throw new RuntimeException(a);
                }
                System.out.println("Ingrese el alimento buscado");
                String alimentoBuscado = dato.next();
                Alimento alimentoBuscar = Alimento.buscarAlimento(alimentos,alimentoBuscado);
                if (alimentoBuscar != null){
                    System.out.println("Alimento si existe");
                }
                else{
                    System.out.println("Alimento no existe");
                }
            }
        });
        MostrarEjerciciosEnRango.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ejercicio.imprimirEjercicioDentroDeRango();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
