package Clases;

public class Persona {
    private String name;

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                '}';
    }
}
