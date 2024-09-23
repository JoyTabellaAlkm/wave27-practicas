package co.mercadolibre.calorias.service;

import co.mercadolibre.calorias.dto.ConsultDTO;

public interface IFoodService {
    public ConsultDTO getCaloriesByPreparation(String name);
}
