public class Categoria{
    private int id;
    private String nombre, descripcion;
    private int valorInscripcionMayores;
    private Integer valorInscripcionMenores;

    public Categoria(int id, String nombre, String descripcion, int valorInscripcionMayores, Integer valorInscripcionMenores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorInscripcionMayores = valorInscripcionMayores;
        this.valorInscripcionMenores = valorInscripcionMenores;
    }

    public int getValorInscripcionMayores() {
        return valorInscripcionMayores;
    }

    public Integer getValorInscripcionMenores() {
        return valorInscripcionMenores;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
