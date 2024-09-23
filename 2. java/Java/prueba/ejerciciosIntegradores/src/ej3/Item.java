package ej3;

public class Item {
    private int codigo;
    private String nombre;
    private int cantidad;
    private Double costo;

    public Item(int codigo, String nombre, int cantidad, double costo){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }
}
