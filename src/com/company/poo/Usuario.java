package com.company.poo;
import java.util.Date;
public class Usuario {
    //atributos
    private String nombre;
    private String rut;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private int edad;
    private EstadoFisico estadoFisico;

    //builder
    public Usuario(String nombre, String rut, Date fechaNacimiento, Date fechaIngreso, int edad, EstadoFisico estadoFisico) {
        this.nombre = nombre;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.edad = edad;
        this.estadoFisico = estadoFisico;
    }

    //getters
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

    //setters
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
}
