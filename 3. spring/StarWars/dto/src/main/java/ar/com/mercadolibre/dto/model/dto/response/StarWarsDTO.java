package ar.com.mercadolibre.dto.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StarWarsDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    @JsonProperty("home-world")
    private String homeworld;
    private String species;

    public StarWarsDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        try{
            this.height = Integer.parseInt(height);
        }catch (Exception e){
            this.height = null;
        }

        try{
            this.mass = Integer.parseInt(mass);
        }catch (Exception e){
            this.mass = null;
        }

        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
