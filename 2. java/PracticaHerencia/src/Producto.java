public class Producto {

    private String nombre;
    private Double precio;


    public Double calcular(Integer cantidadDeProductos){
        return cantidadDeProductos * this.precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " - Precio:" + precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
