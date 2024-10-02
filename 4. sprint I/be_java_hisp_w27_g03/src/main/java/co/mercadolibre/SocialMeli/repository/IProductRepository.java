package co.mercadolibre.SocialMeli.repository;

import co.mercadolibre.SocialMeli.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProducts();
    void fillProduct();
}
