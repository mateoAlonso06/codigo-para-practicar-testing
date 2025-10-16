package tdv.teclasunidos.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SocioTest {

    @Test
    public void crearSocio_datosValidos_creaSocio() throws EdadInvalidaException, NombreMuyLargoException {
        String nombre = "Mateo";
        int edad = 23;
        String direccion = "Arroyo Seco 2500";
        String dni = "43.855.104";

        Socio socio = new Socio(nombre, edad, direccion, dni);

        assertEquals(nombre, socio.getNombre());
        assertEquals(edad, socio.getEdad());
        assertEquals(direccion, socio.getDireccion());
        assertEquals(dni, socio.getDni());
        assertNotNull(socio);
    }

    @Test
    public void crearSocio_datosInvalidos_lanzaExcepcionPorNombre() {
        String nombre = "Jorge Rafael Do Santos Barreiro Gutierrez Miguel Do Ansus Pereyra";
        int edad = 23;
        String direccion = "Arroyo Seco 2500";
        String dni = "43.855.104";

        assertThrows(NombreMuyLargoException.class, () -> new Socio(nombre, edad, direccion, dni));
    }

    @Test
    public void crearSocio_datosInvalidos_lanzaExcepcionPorEdad() {
        String nombre = "Mateo";
        int edad = -100;
        String direccion = "Arroyo Seco 2500";
        String dni = "43.855.104";

        assertThrows(EdadInvalidaException.class, () -> new Socio(nombre, edad, direccion, dni));
    }
}
