package documentos;

import java.util.List;

public class Curriculums implements Imprimible{
    private String nombre;
    private List<String> habilidades;

    public Curriculums(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void hacerImprecion() {
        System.out.println(nombre);
        habilidades.forEach(habilidad -> System.out.println(habilidad));
    }
}
