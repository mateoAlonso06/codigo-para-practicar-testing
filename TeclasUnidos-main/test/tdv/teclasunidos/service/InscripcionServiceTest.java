package tdv.teclasunidos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdv.teclasunidos.entities.Recurso;
import tdv.teclasunidos.entities.Socio;
import tdv.teclasunidos.services.ReservaService;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class InscripcionServiceTest {
    private ReservaService reservaService;

    @BeforeEach
    public void setUp() {
        reservaService = new ReservaService();
    }

    @Test
    public void reservarTestTrue() {
        boolean resultado = false;
        try {
            Recurso recurso = new Recurso("Hotel libertador", "Merlo");
            Socio socio = new Socio("Carlos", 55, "Savedra 33", "12323232");

            LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 14, 0); // 10 de junio de 2024, 14:00
            LocalDateTime fin = inicio.plusHours(2); // 10 de junio de 2024, 16:00

            reservaService.reservar(recurso, socio, inicio, fin);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Recurso recurso2 = new Recurso("Hotel libertador", "Merlo");
            Socio socio2 = new Socio("María", 40, "Belgrano 120", "45678901");
            LocalDateTime inicio2 = LocalDateTime.of(2024, Month.JUNE, 10, 16, 1); // 10 de junio de 2024, 10:00
            LocalDateTime fin2 = inicio2.plusHours(3); // 10 de junio de 2024, 13:00

            resultado = reservaService.reservar(recurso2, socio2, inicio2, fin2);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertTrue(resultado);
    }

    @Test
    public void reservarTestFalse() {
        boolean resultado = true;
        try {
            Recurso recurso = new Recurso("Cabaña del Lago", "Bariloche");
            Socio socio = new Socio("Carlos", 55, "Savedra 33", "12323232");

            LocalDateTime inicio = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0); // 10 de junio de 2024, 14:00
            LocalDateTime fin = inicio.plusHours(2);

            reservaService.reservar(recurso, socio, inicio, fin);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Recurso recurso2 = new Recurso("Cabaña del Lago", "Bariloche");
            Socio socio2 = new Socio("María", 40, "Belgrano 120", "45678901");
            LocalDateTime inicio2 = LocalDateTime.of(2024, Month.JUNE, 10, 16, 0); // 10 de junio de 2024, 16:00
            LocalDateTime fin2 = inicio2.plusHours(3);

            resultado = reservaService.reservar(recurso2, socio2, inicio2, fin2);
        } catch (Exception e) {
            System.out.println(e);
        }
        assertFalse(resultado);
    }
}
