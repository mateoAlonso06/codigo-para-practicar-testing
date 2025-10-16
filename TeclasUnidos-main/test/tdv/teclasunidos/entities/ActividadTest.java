package tdv.teclasunidos.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ActividadTest {
    @Test
    public void toString_datosValidos() {
        String encargado = "Mateo";
        String nombre = "Entrevista residencia";
        String horario = "15:00hs";
        int edadMinima = 18;
        String lugar = "Tandil, Buenos Aires, Argentina";
        int cupo = 100;

        Actividad actividad = new Actividad(nombre, encargado, horario, edadMinima, lugar, cupo);
        assertNotNull(actividad);
        assertEquals(nombre + "*" + lugar, actividad.toString());
    }
}
