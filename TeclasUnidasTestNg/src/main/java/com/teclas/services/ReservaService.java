package com.teclas.services;

import java.time.LocalDateTime;
import java.util.*;

import com.teclas.entities.Recurso;
import com.teclas.entities.Reserva;
import com.teclas.entities.Socio;

public class ReservaService {
    private final Map<String, List<Reserva>> reservasPorRecurso = new HashMap<>();


    public boolean reservar(Recurso recurso, Socio socio, LocalDateTime inicio, LocalDateTime fin) {
        List<Reserva> reservas = reservasPorRecurso.computeIfAbsent(recurso.getNombre(), k -> new ArrayList<>());

        for (Reserva r : reservas) {
            if (r.seSuperpone(inicio, fin)) {
                return false; // Conflicto de horario
            }
        }

        reservas.add(new Reserva(recurso, socio, inicio, fin));
        return true;
    }

    public boolean cancelarReserva(Recurso recurso, Socio socio, LocalDateTime inicio, LocalDateTime fin) {
        List<Reserva> reservas = reservasPorRecurso.get(recurso.getNombre());
        if (reservas == null) return false;

        return reservas.removeIf(r -> r.getSocio().equals(socio) &&
                                      r.getInicio().equals(inicio) &&
                                      r.getFin().equals(fin));
    }

    public List<Reserva> listarReservas(String nombreRecurso) {
        return reservasPorRecurso.getOrDefault(nombreRecurso, new ArrayList<>());
    }
}
