package co.mercadolibre.SocialMeli.repository.impl;

import co.mercadolibre.SocialMeli.entity.Product;
import co.mercadolibre.SocialMeli.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    private List<Product> productList = new ArrayList<>();

    public ProductRepository(List<Product> usersList) {
        fillProduct();
    }

    public void fillProduct(){

        productList.add(new Product(1,"Mesedora","Muebles","Sillas jairo","Blanco", "Realizada con madera de roble"));
        productList.add(new Product(2,"Licuadora","Cocina","Imusa","Negro","Gomela"));
        productList.add(new Product(3,"Silla gamer","Muebles","Sillas jairo","Blanco","Con lucesitas"));
        productList.add(new Product(4,"Almohada de Chayanne","Dormitorio","Chayanne", "Blanco", "Padre de toda Latam"));
        productList.add(new Product(5,"Mesa","Muebles","Sillas jairo","Cafe","Hecha en Polombia"));

    }

    @Override
    public List<Product> findAllProducts() {
        return productList;
    }

}
