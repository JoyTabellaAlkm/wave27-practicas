package Ejercicio3.model;

import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private Double total;

    public Factura() {
    }

    public Factura(String codigo, Cliente cliente, List<Item> listaItems, Double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}


