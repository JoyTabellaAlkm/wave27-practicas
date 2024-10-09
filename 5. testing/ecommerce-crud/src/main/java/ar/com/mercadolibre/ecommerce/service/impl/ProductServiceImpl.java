package ar.com.mercadolibre.ecommerce.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mercadolibre.ecommerce.models.Product;
import ar.com.mercadolibre.ecommerce.repositories.ProductRepository;
import ar.com.mercadolibre.ecommerce.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return repository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        Product existingProduct = repository.findById(id);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return repository.save(existingProduct);
        }

        return null;
    }
    
}