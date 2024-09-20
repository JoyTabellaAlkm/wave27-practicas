public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private double precioMenor;
    private double precioMayor;

    public Categoria(int id, String nombre, String descripcion, double precioMenor, double precioMayor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioMenor = precioMenor;
        this.precioMayor = precioMayor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio(int edad) {
        if (edad < 18) {
            return precioMenor;
        }
        return precioMayor;
    }

    @Override
    public String toString() {
        return nombre + ": " + descripcion;
    }
}
