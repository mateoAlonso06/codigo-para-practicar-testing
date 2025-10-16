package repositories;

import com.teclas.entities.DniInvalidoException;
import com.teclas.entities.EdadInvalidaException;
import com.teclas.entities.NombreMuyLargoException;
import com.teclas.entities.Socio;
import com.teclas.repositories.SocioRepository;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CsvDataProvider;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SocioRepositoryTest {
    private SocioRepository socioRepository;

    @BeforeGroups("smoke")
    public void setUp() {
        this.socioRepository = new SocioRepository();
    }

    @Test(dataProvider = "csvSocio", dataProviderClass = CsvDataProvider.class)
    public void agregarSociosTest_Exito(String nombre, String edad, String direccion, String dni) throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        int edadSocio = Integer.parseInt(edad);

        Socio socio = new Socio(nombre, edadSocio, direccion, dni);

        socioRepository.agregar(socio);

        Socio socioBuscar = socioRepository.buscarPorDni(socio.getDni());

        assertEquals(socioBuscar, socio);
        assertNotNull(socioBuscar);
    }

    @Test(dataProvider = "csvSocio", dataProviderClass = CsvDataProvider.class)
    public void eliminarSociosTest_Exito(String nombre, String edad, String direccion, String dni) throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
        int edadSocio = Integer.parseInt(edad);

        Socio socio = new Socio(nombre, edadSocio, direccion, dni);

        socioRepository.agregar(socio);

        Socio socioBuscar = socioRepository.buscarPorDni(socio.getDni());
        assertEquals(socioBuscar, socio);
        assertNotNull(socioBuscar);

        socioRepository.eliminar(socio.getDni());

        socioBuscar = socioRepository.buscarPorDni(socio.getDni());

        assertNull(socioBuscar);
    }

    @Test(groups = {"smoke"})
    public void listarSocios_Exito() throws EdadInvalidaException, NombreMuyLargoException, DniInvalidoException {
//        SocioRepository socioRepository = new SocioRepository();
        List<Socio> socios = new ArrayList<>();

        Socio socio1 = new Socio("Juan Perez", 30, "Calle Falsa 123", "1234567");
        Socio socio2 = new Socio("Maria Gomez", 25, "Av. Siempre Viva 742", "2345678");
        Socio socio3 = new Socio("Carlos Lopez", 40, "Boulevard Central 1000", "3456789");
        Socio socio4 = new Socio("Ana Torres", 50, "Ruta 8 Km 50", "4567890");
        Socio socio5 = new Socio("Lucia Fernandez", 28, "Diagonal Norte 555", "5678901");

        socioRepository.agregar(socio1);
        socioRepository.agregar(socio2);
        socioRepository.agregar(socio3);
        socioRepository.agregar(socio4);
        socioRepository.agregar(socio5);

        socios = socioRepository.listar();

        assertNotNull(socios);
        assertEquals(socios.size(), 5);
    }
}
