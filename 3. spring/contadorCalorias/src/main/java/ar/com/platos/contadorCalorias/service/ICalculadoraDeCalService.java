package ar.com.platos.contadorCalorias.service;

import ar.com.platos.contadorCalorias.dto.PlatoDTO;
import ar.com.platos.contadorCalorias.entity.Ingrediente;
import ar.com.platos.contadorCalorias.entity.Plato;

public interface ICalculadoraDeCalService {
    Integer calcularCaloriasDePlato(Plato plato);
    Ingrediente ingredienteMasCaloricoDelPlato(Plato plato);
    PlatoDTO mostrarInfoDePlato(String nombreDePlato);
}
