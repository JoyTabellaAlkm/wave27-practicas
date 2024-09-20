package com.ejercicios.CalculadoraCalorias.service;

import com.ejercicios.CalculadoraCalorias.dto.DishInfoResponseDTO;

public interface ICalcularCaloriasService {
    DishInfoResponseDTO getDishInfoByName(String name);
}
