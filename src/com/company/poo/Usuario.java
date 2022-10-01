package com.company.poo;
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
}
