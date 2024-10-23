package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;

import java.util.List;

public interface IClothesService {
    Clothes save(Clothes clothes);

    List<Clothes> findAll();

    Clothes findClothes(Long code);

    Clothes updateClothes(Long code, Clothes clothes);

    String deleteClothes(Long code);

    List<Clothes> findAllBySize(Double size);

    List<Clothes> findAllByName(String name);
}
