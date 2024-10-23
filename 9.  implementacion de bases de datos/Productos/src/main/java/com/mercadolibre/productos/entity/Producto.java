package com.mercadolibre.productos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "productos")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    @Field(name = "precio_venta")
    private Double precioVenta;
    @Field(name = "precio_costo")
    private Double precioCosto;
    private Integer stock;
}
