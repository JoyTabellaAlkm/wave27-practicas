package ar.com.mercadolibre.ejercicioStarWars.entity.dto;

import ar.com.mercadolibre.ejercicioStarWars.entity.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDto {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public static PersonajeDto from(Personaje personaje){
        return new PersonajeDto(personaje.getName(),
                personaje.getHeight(), personaje.getMass(),
                personaje.getGender(), personaje.getHomeworld(),
                personaje.getSpecies());
    }
}
