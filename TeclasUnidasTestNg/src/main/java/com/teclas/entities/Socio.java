package com.teclas.entities;

import java.util.Objects;

public class Socio {
    private String nombre;
    private int edad;
    private String direccion;
    private String dni;

    public Socio(String nombre, int edad, String direccion, String dni) throws NombreMuyLargoException, EdadInvalidaException, DniInvalidoException {
    	if (nombre.length()>51) 
    		throw new NombreMuyLargoException();
        this.nombre = nombre;

        if (edad <0 ||edad >100) 
        	throw new EdadInvalidaException();

        this.edad = edad;
        this.direccion = direccion;

        if (this.noCumpleRestriccion(dni))
            throw new DniInvalidoException();

        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return getEdad() == socio.getEdad() && Objects.equals(getNombre(), socio.getNombre()) && Objects.equals(getDireccion(), socio.getDireccion()) && Objects.equals(getDni(), socio.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad(), getDireccion(), getDni());
    }

    public boolean noCumpleRestriccion(String dni) {
        return !((dni.length() >= 6 && dni.length() <= 7) && (!dni.contains(".")));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}

