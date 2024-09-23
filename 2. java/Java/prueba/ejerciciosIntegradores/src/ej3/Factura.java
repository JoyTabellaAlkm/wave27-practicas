package ej3;

import java.util.List;

public class Factura {
    Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items, double total){
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    }

