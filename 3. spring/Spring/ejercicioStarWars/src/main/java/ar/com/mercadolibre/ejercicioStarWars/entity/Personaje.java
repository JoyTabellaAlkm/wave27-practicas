package ar.com.mercadolibre.ejercicioStarWars.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    private int height;
    private int mass;
    private String hairColor;// no mostrar
    private String skinColor;// no mostrar
    private String eyeColor;// no mostrar
    private String birthYear;// no mostrar
    private String gender;
    private String homeworld;
    private String species;
}
