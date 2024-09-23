package clases;

public class Categoria {

    private int id;
    private String nombre;
    private String descripcion;
    private int montoMenores;
    private int montoMayores;

    public Categoria(int id, String nombre, String descripcion, int montoMenores, int montoMayores){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMenores = montoMenores;
        this.montoMayores = montoMayores;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMontoMenores() {
        return montoMenores;
    }

    public int getMontoMayores() {
        return montoMayores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMontoMenores(int montoMenores) {
        this.montoMenores = montoMenores;
    }

    public void setMontoMayores(int montoMayores) {
        this.montoMayores = montoMayores;
    }
}


