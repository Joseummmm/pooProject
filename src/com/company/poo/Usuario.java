package com.company.poo;
import java.util.Date;
import java.util.Scanner;

public class Usuario {
    //atributos
    private String nombre;
    private String rut;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private int edad;
    private EstadoFisico estadoFisico;
    private Rutina rutinaRecomendada;
    private Dieta dietaRecomendada;
    public Scanner dato = new Scanner (System.in);
    
    
    //builders
    public Usuario(String nombre, String rut, Date fechaNacimiento, Date fechaIngreso, int edad, EstadoFisico estadoFisico) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.edad = edad;
        this.estadoFisico = estadoFisico;
    }
    
    
    public Usuario(){
        String nombre,rut;
        
        System.out.println("Ingrese nombre");
        nombre = dato.next();
        
        while(nombre.matches("[0-9-]*")){
            System.out.println("Dato en formato incorrecto");
            System.out.println("Ingrese nombre");
            nombre = dato.next();
        }
        
        System.out.println("Ingrese rut sin puntos y sin guion y si tiene K reemplaze por un 0");
        rut = dato.next();
        
        while(!rut.matches("[0-9-]*")){
            System.out.println("Dato en formato incorrecto");
            System.out.println("Ingrese rut sin puntos y sin guion y si tiene K reemplaze por un 0");
            rut = dato.next();
        }
        
        System.out.println("Ingrese edad");
        edad = dato.nextInt();
        
        this.Nombre = nombre;
        this.Rut = rut;
        this.edad = edad;
    }

    
    //getters and setters
    public String getNombre() {
        return this.nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
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

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
}
