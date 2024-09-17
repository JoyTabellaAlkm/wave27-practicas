package org.bootcamp.supermercado;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.bootcamp.repository.BaseEntity;

import java.util.UUID;

@AllArgsConstructor @ToString
public class Item extends BaseEntity<UUID> {
    private String codigo;
    private String nombre;

    @Getter(AccessLevel.PROTECTED)
    private int cantidad;
    @Getter(AccessLevel.PROTECTED)
    private double costoUnitario;
}
