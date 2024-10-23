package ar.com.mercadolibre.clothes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@NoArgsConstructor
@Document(indexName = "clothes")
public class Clothes {
    @Id
    private String id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double selling_price;
}
