package tdv.teclasunidos.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RecursoTest {

    @Test
    public void crearRecurso_datosValidos_creaRecurso() {
        String nombre = "Sala de reuniones";
        String ubicacion = "Piso 2";

        Recurso recurso = Recurso.crearRecurso(nombre, ubicacion);
        assertNotNull(recurso);
        assertEquals(nombre, recurso.getNombre());
        assertEquals(ubicacion, recurso.getUbicacion());
    }

    @Test
    public void crearRecurso_datosInvalidos_retornaNull() {
        String nombre = "Oficina";
        String ubicacion = "Piso 2";

        Recurso recurso = Recurso.crearRecurso(nombre, ubicacion);
        assertNull(recurso);
    }
}
