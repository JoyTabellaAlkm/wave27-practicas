package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data

public class Factura {

    private Cliente cliente;
    private List<Item> listaCompra;
    private Double costoTotal;

    public Factura(Cliente cliente, List<Item> listaCompras){
        this.cliente = cliente;
        this.listaCompra = listaCompras;
        calcularCostoTotal();
    }

    public void calcularCostoTotal(){
        Double costoTotal = this.getListaCompra().stream()
                .mapToDouble(item -> item.getCostoUnitario() * item.getCantidad())
                .sum();

        this.costoTotal = costoTotal;
    }
}
