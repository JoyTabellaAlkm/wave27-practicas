package model;

import java.util.List;
import java.util.Optional;

public class Factura {
    private Long idFactura;
    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

    public Factura() {
        this.total = calcularTotal();
    }


    public Factura(Long idFactura, Cliente cliente, List<Item> listaItems) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = calcularTotal();
    }


    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calcularTotal(){
       return listaItems.stream().mapToDouble(Item::getPrecioUnitario).sum();
    }

    @Override
    public String toString() {
        return "Factura:" +
                "\nNro=" + idFactura +
                "\ncliente=" + cliente +
                "\nlistaItems=" + listaItems +
                "\ntotal=" + total;
    }
}
