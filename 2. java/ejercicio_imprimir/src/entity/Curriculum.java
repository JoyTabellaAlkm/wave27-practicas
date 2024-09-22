package entity;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {
    private Persona persona;
    private List<String> habilidades;

    public Curriculum() {
        this.habilidades = new ArrayList<>();

    }

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }
}
