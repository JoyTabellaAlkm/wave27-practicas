package org.bootcamp.supermercado;

import lombok.Getter;
import org.bootcamp.repository.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente extends BaseEntity<UUID> {
    @Getter
    private String dni;
    private String nombre;
    private String apellido;
    private List<Factura> facturas;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facturas = new ArrayList<>();
    }

    public void addFactura(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", facturas=" + facturas +
                ", id=" + id +
                '}';
    }
}
