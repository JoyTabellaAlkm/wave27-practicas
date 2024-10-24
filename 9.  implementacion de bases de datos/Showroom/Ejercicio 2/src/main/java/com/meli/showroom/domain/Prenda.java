package com.meli.showroom.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "prenda")
public class Prenda {
    @Id
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;;
    private String color;
    private String talla;
    private int cantidad;
    @Field(name = "precio_venta")
    private Double precioVenta;


}
