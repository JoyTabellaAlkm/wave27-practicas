package ar.org.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true) //para ignorar propiedad sales
public class ClothingDTO {

    private Long code;
    private String name;
    private String type;
    private String brand;
    private String coulor;
    private String size; //talle
    private int count;
    private double price;
}
