package tdv.teclasunidos.entities;

public class Recurso {
    private String nombre;
    private String ubicacion;

    private Recurso(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public static Recurso crearRecurso(String nombre, String ubicacion) {
        if ("Oficina".equals(nombre)) {
            return null;
        }
        return new Recurso(nombre, ubicacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

