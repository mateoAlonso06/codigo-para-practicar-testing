package com.teclas.services;

import com.teclas.entities.Actividad;
import com.teclas.entities.Socio;

public class InscripcionService {
    public boolean inscribir(Socio socio, Actividad actividad) {
        return actividad.agregarInscripcion(socio);
    }

    public boolean eliminarInscripcion(Socio socio, Actividad actividad) {
        return actividad.eliminarInscripcion(socio);
    }
}

