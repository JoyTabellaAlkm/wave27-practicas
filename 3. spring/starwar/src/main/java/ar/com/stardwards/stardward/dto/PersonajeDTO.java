package ar.com.stardwards.stardward.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PersonajeDTO implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworker;
    private String species;

    public PersonajeDTO(String name, String height, String mass, String gender, String homeworker, String species) {
        this.name = name;
        try {
            this.height = Integer.parseInt(height);
        } catch (Exception e) {
            this.height = 0;
        }
        try {
            this.mass = Integer.parseInt(mass);
        } catch (Exception e) {
            this.mass = 0;
        }
        this.gender = gender;
        this.homeworker = homeworker;
        this.species = species;
    }
}