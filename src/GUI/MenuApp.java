package GUI;

import Alimentacion.Alimento;
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
    private JButton nuevoUserYPass;
    private JButton eliminarEjercicioButton;
    private JButton buscarAlimentoButton;
    private JButton mostrarAlimentosButton;
    private JButton crearAlimentoButton;
    private JButton MostrarEjerciciosEnRango;
    private JButton cerrarProgramaButton;
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

        eliminarEjercicioButton = new JButton("Eliminar Ejercicio");
        eliminarEjercicioButton.setBounds(120,20,80,25);
        panel.add(eliminarEjercicioButton);

        buscarAlimentoButton = new JButton("buscar alimento");
        buscarAlimentoButton.setBounds(240,20,80,25);
        panel.add(buscarAlimentoButton);

        mostrarAlimentosButton = new JButton("Mostrar alimentos por consola");
        mostrarAlimentosButton.setBounds(20,60,80,25);
        panel.add(mostrarAlimentosButton);

        crearAlimentoButton = new JButton("Crear alimento");
        crearAlimentoButton.setBounds(120,60,80,25);
        panel.add(crearAlimentoButton);

        MostrarEjerciciosEnRango = new JButton("Mostrar ejercicios en rango");
        panel.add(MostrarEjerciciosEnRango);

        cerrarProgramaButton = new JButton("Cerrar programa");
        cerrarProgramaButton.setBounds(240,60,80,25);
        panel.add(cerrarProgramaButton);

        frame.setVisible(true);

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
                } catch (FileNotFoundException a) {
                    throw new RuntimeException(a);
                }

                try {
                    Ejercicio.eliminarEjerciciosDisponible(ejercicios,ejercicio);
                } catch (IOException a) {
                    throw new RuntimeException(a);
                }
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
        crearAlimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alimento.obtenerAlimento();
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
