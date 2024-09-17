package Integrador;

import java.util.List;

public class Factura {

    private Cliente cliente;

    List<Item> itens;

    private double total;

    public Factura(Cliente cliente, List<Item> itens, double total) {
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
