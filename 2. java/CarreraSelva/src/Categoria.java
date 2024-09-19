import java.util.List;

public class Categoria {
    public int idCat;
    public String nombre;
    public String descripcion;
    public double montoRecaudado;

    public Categoria(int idCat, String nombre, String descripcion) {
        this.idCat = idCat;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void anadirMonto(double monto){
        montoRecaudado = montoRecaudado + monto;
    }

    @Override
    public String toString() {
        return
                "Id de categoría: " + idCat +
                ", Categoría: " + nombre +
                ", Descripción: " + descripcion;
    }
}
