package ar.com.platos.contadorCalorias.dto;

import ar.com.platos.contadorCalorias.entity.Ingrediente;

import java.io.Serializable;
import java.util.List;

public class PlatoDTO implements Serializable {
    private List<Ingrediente> ingredientes;
    private String nombre;
    private Integer cantTotalCalorias;
    private Ingrediente ingredienteMasCalorico;

    public PlatoDTO(List<Ingrediente> ingredientes, String nombre, Integer cantTotalCalorias, Ingrediente ingredienteMasCalorico) {
        this.ingredientes = ingredientes;
        this.nombre = nombre;
        this.cantTotalCalorias = cantTotalCalorias;
        this.ingredienteMasCalorico = ingredienteMasCalorico;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantTotalCalorias() {
        return cantTotalCalorias;
    }

    public void setCantTotalCalorias(Integer cantTotalCalorias) {
        this.cantTotalCalorias = cantTotalCalorias;
    }

    public Ingrediente getIngredienteMasCalorico() {
        return ingredienteMasCalorico;
    }

    public void setIngredienteMasCalorico(Ingrediente ingredienteMasCalorico) {
        this.ingredienteMasCalorico = ingredienteMasCalorico;
    }
}
