package ar.com.mercadolibre.clothes.service;

import ar.com.mercadolibre.clothes.entity.Clothes;

import java.util.List;

public interface IClothesService {
    Clothes save(Clothes clothes);

    List<Clothes> findAll();

    Clothes findClothes(String code);

    Clothes updateClothes(String code, Clothes clothes);

    String deleteClothes(String code);

    List<Clothes> findAllBySize(String size);

    List<Clothes> findAllByName(String name);
}
