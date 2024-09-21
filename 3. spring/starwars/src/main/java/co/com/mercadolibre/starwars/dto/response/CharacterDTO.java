package co.com.mercadolibre.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CharacterDTO {
    private String name;
    private Double height;
    private Double mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        try{
            this.height = Double.parseDouble(height);
        }catch (Exception e)
        {
            this.height = null;
        }
        try{
            this.mass = Double.parseDouble(mass);
        }catch (Exception e)
        {
            this.mass = null;
        }

        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
