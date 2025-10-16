package com.teclas.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actividad {
    private String nombre;
    private String encargado;
    private String horario;
    private int edadMinima;
    private String lugar;
    private int cupo;
    private List<Socio> inscriptos = new ArrayList<>();

    public Actividad(String nombre, String encargado, String horario, int edadMinima, String lugar, int cupo) {
        this.nombre = nombre;
        this.encargado = encargado;
        this.horario = horario;
        this.edadMinima = edadMinima;
        this.lugar = lugar;
        this.cupo = cupo;
    }

    // Getters, setters y métodos auxiliares
    public boolean agregarInscripcion(Socio socio) {
        if (socio.getEdad() <= edadMinima || inscriptos.size() == cupo) {
            return false;
        }
        return inscriptos.add(socio);
    }

    public boolean eliminarInscripcion(Socio socio) {
        return inscriptos.remove(socio);
    }

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getEncargado() {
		// TODO Auto-generated method stub
		return encargado;
	}

	public int getEdadMinima() {
		// TODO Auto-generated method stub
		return edadMinima;
	}

	public int getCupo() {
		// TODO Auto-generated method stub
		return cupo;
	}
	public String toString() {
		return nombre+"*"+lugar;
	}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getCantidadInscriptos() {
        return inscriptos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return getEdadMinima() == actividad.getEdadMinima() && getCupo() == actividad.getCupo() && Objects.equals(getNombre(), actividad.getNombre()) && Objects.equals(getEncargado(), actividad.getEncargado()) && Objects.equals(horario, actividad.horario) && Objects.equals(lugar, actividad.lugar) && Objects.equals(inscriptos, actividad.inscriptos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEncargado(), horario, getEdadMinima(), lugar, getCupo(), inscriptos);
    }
}

