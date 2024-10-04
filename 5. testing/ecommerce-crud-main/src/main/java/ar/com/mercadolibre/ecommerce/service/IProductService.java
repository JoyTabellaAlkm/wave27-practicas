package ar.com.mercadolibre.ecommerce.service;

import java.util.List;

import ar.com.mercadolibre.ecommerce.models.Product;

public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(String id);

    Product createProduct(Product product);

    Product updateProduct(String id, Product updatedProduct);

}
