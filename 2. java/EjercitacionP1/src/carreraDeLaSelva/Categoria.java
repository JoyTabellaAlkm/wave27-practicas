package carreraDeLaSelva;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Integer montoMenores;
    private Integer montoMayores;

    public Categoria(int id, String nombre, String descripcion, Integer montoMenores, Integer montoMayores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.montoMenores = montoMenores;
        this.montoMayores = montoMayores;
    }

    public Integer getMontoMenores() {
        return montoMenores;
    }

    public Integer getMontoMayores() {
        return montoMayores;
    }

    public String getNombre() {
        return nombre;
    }
}