package tdv.teclasunidos.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdv.teclasunidos.entities.Actividad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActividadRepositoryTest {
    private ActividadRepository actividadRepository;

    @BeforeEach // se lanza antes de cada test
    public void setUp() {
        this.actividadRepository = new ActividadRepository();
    }

    @Test
    public void agregarTestTrue() {
        Actividad a = new Actividad("Futbol", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

        actividadRepository.agregar(a);

        Actividad resultado = actividadRepository.buscarPorNombre("Futbol");
        assertEquals("Futbol", resultado.getNombre());
        assertEquals(1, actividadRepository.cantidad());
    }

    @Test
    public void agregarTestFalse() {
        assertNull(actividadRepository.buscarPorNombre("Tenis"));
    }

    @Test
    public void eliminarTestTrue() {
        Actividad a = new Actividad("Futbol", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

        actividadRepository.agregar(a);
        actividadRepository.eliminar(a.getNombre());
        assertNull(actividadRepository.buscarPorNombre(a.getNombre()));
    }

    @Test
    public void eliminarTestFalse() {
        Actividad a = new Actividad("Futbol", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

        actividadRepository.agregar(a);

        actividadRepository.eliminar("Tenis");

        assertNotNull(actividadRepository.buscarPorNombre(a.getNombre()));
    }

    @Test
    public void buscarPorNombreTestTrue() {
        Actividad a = new Actividad("Futbol", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

        String nombre = "Futbol";

        actividadRepository.agregar(a);
        Actividad resultado = actividadRepository.buscarPorNombre(nombre);

        assertEquals("Futbol", resultado.getNombre());
    }

    @Test
    public void buscarPorNombreTestFalse() {
        String nombre = "Tenis";

        // Hace falta agregar un elemento? si fuerzo que falle
        actividadRepository.buscarPorNombre(nombre);

        Actividad resultado = actividadRepository.buscarPorNombre(nombre);

        assertNull(resultado);
    }

    @Test
    public void listarTestTrue() {
        List<Actividad> actividadesEsperadas = new ArrayList<>(List.of(
                new Actividad("Basquet", "Lucia", "16:00hs", 18, "Polideportivo central", 10),
                new Actividad("Voley", "Carlos", "18:00hs", 20, "Club social", 12)
        ));

        Actividad b = new Actividad("Basquet", "Lucia", "16:00hs", 18, "Polideportivo central", 10);
        Actividad c = new Actividad("Voley", "Carlos", "18:00hs", 20, "Club social", 12);

        actividadRepository.agregar(b);
        actividadRepository.agregar(c);

        List<Actividad> resultado = actividadRepository.listar();

        actividadesEsperadas.sort(Comparator.comparing(Actividad::getNombre));
        resultado.sort(Comparator.comparing(Actividad::getNombre));

        assertIterableEquals(actividadesEsperadas, resultado);
    }

    @Test
    public void actualizarTestTrue() {
        Actividad a = new Actividad("Futbol", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

        actividadRepository.agregar(a);

        a.setEncargado("Juan");

        actividadRepository.actualizar(a);

        assertEquals("Juan", actividadRepository.buscarPorNombre("Tenis").getEncargado());
    }

    @Test
    public void actualizarTestFalse() {
        Actividad a = new Actividad("Tenis", "Manuel", "14:00hs", 16, "Cancha independiente", 11);

//        actividadRepository.actualizar(a);

        assertNull(actividadRepository.buscarPorNombre(a.getNombre()));
    }
}