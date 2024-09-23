package co.mercadolibre.deportistas.dto;

import co.mercadolibre.deportistas.entity.Deporte;

import java.util.List;

public class ConsultaDTO {
    private String nombre;
    private String apellido;
    private List<Deporte> listaDeportes;

    public ConsultaDTO(String nombre, String apellido, List<Deporte> listaDeportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaDeportes = listaDeportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(List<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }
}
