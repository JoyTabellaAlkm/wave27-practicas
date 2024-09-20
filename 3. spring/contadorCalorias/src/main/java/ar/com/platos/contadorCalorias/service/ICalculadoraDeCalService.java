package ar.com.platos.contadorCalorias.service;

import ar.com.platos.contadorCalorias.dto.PlatoDTO;
import ar.com.platos.contadorCalorias.entity.Ingrediente;
import ar.com.platos.contadorCalorias.entity.Plato;

import java.util.List;

public interface ICalculadoraDeCalService {
    Integer calcularCaloriasDePlato(Plato plato);
    Ingrediente ingredienteMasCaloricoDelPlato(Plato plato);
    PlatoDTO mostrarInfoDePlato(String nombreDePlato);
    List<PlatoDTO> mostrarInfoDeCadaPlato(List<String> platos);
}
