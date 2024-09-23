package co.arg.mercadolibre.starwars.dto;

import lombok.Data;

//@Data
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(Integer mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public PersonajeDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        try {
            this.height = Integer.parseInt(height);
        }catch (Exception e){
            this.height = null;
        }
        try {
            this.mass = Integer.parseInt(mass);
        }catch (Exception e){
            this.mass = null;
        }
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}
