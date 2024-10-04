package ar.com.mercadolibre.ecommerce.unit;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import ar.com.mercadolibre.ecommerce.models.Product;
import ar.com.mercadolibre.ecommerce.repositories.ProductRepository;
import ar.com.mercadolibre.ecommerce.service.impl.ProductServiceImpl;

public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Product product1 = new Product("1", "Product 1", 10.0);
        Product product2 = new Product("2", "Product 2", 20.0);
        List<Product> mockProducts = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(mockProducts);

        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertEquals(2, products.size());
    }

    @Test
    public void testSaveNewProduct() {
        Product newProduct = new Product(null, "Product 3", 30.0);
        when(productRepository.save(newProduct)).thenReturn(new Product("3", "Product 3", 30.0));

        Product savedProduct = productService.createProduct(newProduct);
        assertNotNull(savedProduct);
        assertEquals("3", savedProduct.getId());
    }

    @Test
    public void testFindById() {
        Product product = new Product("1", "Product 1", 10.0);
        when(productRepository.findById("1")).thenReturn(product);

        Product foundProduct = productService.getProductById("1");
        assertNotNull(foundProduct);
        assertEquals("Product 1", foundProduct.getName());

        Product notFoundProduct = productService.getProductById("999");
        assertNull(notFoundProduct);
    }
}