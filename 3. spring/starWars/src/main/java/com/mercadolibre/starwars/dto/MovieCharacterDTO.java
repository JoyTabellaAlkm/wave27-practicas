package com.mercadolibre.starwars.dto;

public class MovieCharacterDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public MovieCharacterDTO(String name, String height, String mass, String gender, String homeworld, String species) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;

        try {
            this.height = Integer.parseInt(height);
            this.mass = Integer.parseInt(mass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.height = null;
            this.mass = null;
        }
    }
}
