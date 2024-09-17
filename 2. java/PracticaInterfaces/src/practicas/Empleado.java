package practicas;

public class Empleado {
    private int id;
    private String nombre;
    private boolean activo;

    public Empleado(int id, String nombre, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", activo=" + activo +
                '}';
    }
}