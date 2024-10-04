package ar.com.mercadolibre.ecommerce.repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.mercadolibre.ecommerce.models.Product;

@Repository
public class ProductRepository {

    private List<Product> products = new ArrayList<>(); 
    private int nextId = 1; 

    public ProductRepository() {
        loadProducts();
    }

    public void loadProducts() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Product[] loadedProducts = mapper.readValue(new File("src/main/resources/products.json"), Product[].class);
            products.addAll(Arrays.asList(loadedProducts));
            
            for (Product product : products) {
                if (product.getId() != null) { // Si ya tiene ID, actualiza nextId
                    int id = Integer.parseInt(product.getId());
                    if (id >= nextId) {
                        nextId = id + 1;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> findAll() {
        return products;
    }

    public Product save(Product product) {
        // Asignar un ID autoincremental al nuevo producto
        product.setId(String.valueOf(nextId));
        products.add(product);
        nextId++; // Incrementar el siguiente ID
        return product;
    }

    public Product findById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteAll() {
        products.clear(); // Limpia la lista de productos
        nextId = 1; // Reinicia el siguiente ID a 1
    }
}
