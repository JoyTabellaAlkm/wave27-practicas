package clases;

import interfaces.IImprimible;

import java.util.List;

public class Curriculum implements IImprimible {
    private String nombreCompleto;
    private int edad;
    private List<String> listaHabilidades;

    public Curriculum(String nombreCompleto, int edad, List<String> listaHabilidades) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.listaHabilidades = listaHabilidades;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(List<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
    }
}
