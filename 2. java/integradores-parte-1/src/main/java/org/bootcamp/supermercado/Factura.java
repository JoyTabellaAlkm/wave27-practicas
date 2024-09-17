package org.bootcamp.supermercado;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bootcamp.repository.BaseEntity;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor @ToString
public class Factura extends BaseEntity<UUID> {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(List<Item> items) {
        this.items = items;
        this.total = items.stream().mapToDouble(item -> item.getCostoUnitario() * item.getCantidad()).sum();
    }
}
