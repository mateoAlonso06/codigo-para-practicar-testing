package utils;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProvider {
    private static List<Object[]> datosSocio = cargarDatosSocio();

    private static List<Object[]> cargarDatosSocio() {
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/test/resources/socio.csv"))) {
            reader.readNext(); // Salta la cabecera
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @DataProvider(name = "csvSocio")
    public static Object[][] readSocioCsv() {
        return datosSocio.toArray(new Object[0][]);
    }

    public static int getSocioSize() {
        return datosSocio.size();
    }

    // Los otros DataProviders pueden seguir usando readCsv si no necesitas el tamaño
    @DataProvider(name = "csvReserva")
    public static Object[][] readReservaCsv() throws Exception {
        return readCsv("src/test/resources/reserva.csv");
    }

    @DataProvider(name = "csvActividad")
    public static Object[][] readActividadCsv() throws Exception {
        return readCsv("src/test/resources/actividad.csv");
    }

    @DataProvider(name = "csvRecurso")
    public static Object[][] readRecursoCsv() throws Exception {
        return readCsv("src/test/resources/recurso.csv");
    }

    private static Object[][] readCsv(String path) throws Exception {
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            reader.readNext(); // Salta la cabecera
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        }
        return data.toArray(new Object[0][]);
    }
}
