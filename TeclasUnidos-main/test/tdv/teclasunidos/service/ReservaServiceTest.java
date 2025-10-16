package tdv.teclasunidos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdv.teclasunidos.entities.Recurso;
import tdv.teclasunidos.entities.Reserva;
import tdv.teclasunidos.entities.Socio;
import tdv.teclasunidos.services.ReservaService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaServiceTest {
    private ReservaService reservaService;

    @BeforeEach
    public void setUp() {
        reservaService = new ReservaService();
    }

    @Test
    public void reservar_recursoDisponible_devuelveTrue() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Hotel libertador", "Merlo");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 14, 0);
        LocalDateTime fin = inicio.plusHours(2);

        // primera reserva debe tener éxito
        assertTrue(reservaService.reservar(recurso, socio, inicio, fin));

        // segundo socio y horario no solapado -> también debe tener éxito
        Socio socio2 = new Socio("María", 40, "Belgrano 120", "1234567");
        LocalDateTime inicio2 = LocalDateTime.of(2024, Month.JUNE, 10, 16, 1);
        LocalDateTime fin2 = inicio2.plusHours(3);

        boolean resultado = reservaService.reservar(recurso, socio2, inicio2, fin2);
        assertTrue(resultado);
    }

    @Test
    public void reservar_recursoOcupado_devuelveFalse() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0);
        LocalDateTime fin = inicio.plusHours(2);

        // reserva inicial
        assertTrue(reservaService.reservar(recurso, socio, inicio, fin));

        // intento reservar mismo recurso y mismo horario -> debe fallar
        Socio socio2 = new Socio("María", 40, "Belgrano 120", "1234567");

        boolean resultado = reservaService.reservar(recurso, socio2, inicio, fin.plusMinutes(0));
        assertFalse(resultado);
    }

    @Test
    public void reservar_parametrosNull_lanzaNullPointerException() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Hotel libertador", "Merlo");
        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = inicio.plusHours(1);

        assertAll(
                () -> assertThrows(NullPointerException.class, () -> reservaService.reservar(null, socio, inicio, fin))
//                () -> assertThrows(NullPointerException.class, () -> reservaService.reservar(recurso, null, inicio, fin)),
//                () -> assertThrows(NullPointerException.class, () -> reservaService.reservar(recurso, socio, null, fin)),
//                () -> assertThrows(NullPointerException.class, () -> reservaService.reservar(recurso, socio, inicio, null))
        );
    }

    @Test
    public void cancelarReserva_existente_devuelveTrue() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0);
        LocalDateTime fin = inicio.plusHours(2);

        assertTrue(reservaService.reservar(recurso, socio, inicio, fin));

        boolean resultado = reservaService.cancelarReserva(recurso, socio, inicio, fin);
        assertTrue(resultado);
    }

    @Test
    public void cancelarReserva_existente_NoEsPersonaAutorizada() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0);
        LocalDateTime fin = inicio.plusHours(2);

        assertTrue(reservaService.reservar(recurso, socio, inicio, fin));

        boolean resultado = reservaService.cancelarReserva(recurso, new Socio("Pepo", 44, "Indigente", "1234567"), inicio, fin);
        assertFalse(resultado);
    }

    @Test
    public void cancelarReserva_inexistente_devuelveFalse_y_noModificaEstado() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0);
        LocalDateTime fin = inicio.plusHours(2);

        boolean resultado = reservaService.cancelarReserva(recurso, socio, inicio, fin);
        assertFalse(resultado);

        List<Reserva> reservas = reservaService.listarReservas(recurso.getNombre());
        assertNotNull(reservas);
        assertTrue(reservas.isEmpty());
    }

    @Test
    public void listarReservas_cuandoHayUnaReserva_devuelveListaConEsaReserva() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        Socio socio = new Socio("Carlos", 55, "Savedra 33", "1234567");

        LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0);
        LocalDateTime fin = inicio.plusHours(2);

        assertTrue(reservaService.reservar(recurso, socio, inicio, fin));

        List<Reserva> reservas = reservaService.listarReservas(recurso.getNombre());

        assertNotNull(reservas);
        assertEquals(1, reservas.size());

        Reserva reserva = reservas.get(0);
        assertEquals(recurso, reserva.getRecurso());
        assertEquals(socio, reserva.getSocio());
        assertEquals(inicio, reserva.getInicio());
        assertEquals(fin, reserva.getFin());
    }

    @Test
    public void listarReservas_sinReservas_devuelveListaVacia() throws Exception {
        Recurso recurso = Recurso.crearRecurso("Cabaña del Lago", "Bariloche");
        assertNotNull(recurso);

        List<Reserva> reservas = reservaService.listarReservas(recurso.getNombre());

        assertNotNull(reservas);
        assertTrue(reservas.isEmpty());
    }
}
