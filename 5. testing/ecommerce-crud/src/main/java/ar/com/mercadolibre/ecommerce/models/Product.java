package ar.com.mercadolibre.ecommerce.models;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    
}
