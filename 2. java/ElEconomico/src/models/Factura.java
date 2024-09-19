package models;

import models.productos.Item;

import java.util.List;

public class Factura {
    long codigo;
    private Cliente cliente;
    private double montoTotal;
    private List<Item> items;

    public Factura() {
    }

    public Factura(long codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        calcularMontoTotal();
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }

    public void calcularMontoTotal() {
        montoTotal = items.stream()
                .mapToDouble(Item::getPrecio)
                .sum();
    }

    public boolean esMismoCodigo(long codigo) {
        return codigo == this.codigo;
    }
}
