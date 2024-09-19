package personas;

import java.util.List;

public class Persona {
    private String nombre;
    protected List<String> atributos;
    protected List<String> habilidades;

    public Persona(String nombre, List<String> atributos, List<String> habilidades) {
        this.nombre = nombre;
        this.atributos = atributos;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<String> atributos) {
        this.atributos = atributos;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
