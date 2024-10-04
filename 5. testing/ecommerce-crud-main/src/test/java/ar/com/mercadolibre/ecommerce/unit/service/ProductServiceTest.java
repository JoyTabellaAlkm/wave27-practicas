package ar.com.mercadolibre.ecommerce.unit.service;

import ar.com.mercadolibre.ecommerce.models.Product;
import ar.com.mercadolibre.ecommerce.repositories.ProductRepository;
import ar.com.mercadolibre.ecommerce.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImpl service;

    Product p1;
    Product p2;


    @BeforeEach
    public  void setUp() {
        p1 = new Product("1" ,"Producto 1", 100.0);
        p2 = new Product("2" ,"Producto 2", 200.0);
    }

    @Test
    public void getAllTest() throws Exception{
        //Arrange
        List<Product> products = List.of(p1, p2);
        when(repository.findAll()).thenReturn(products);

        //Act
        List<Product> result = repository.findAll();

        //Assert
        assertEquals(2, result.size());
        assertEquals(p1, result.get(0));
        assertEquals(p2, result.get(1));
        assertFalse(result.isEmpty());
    }


    @Test
    public void getProductByExistingId() throws Exception{
        //Arrange
        String id = "1";
        when(repository.findById(id)).thenReturn(p1);

        //Act
        Product result = service.getProductById(id);

        //Assert
        assertEquals(p1, result);
        assertNotNull(result);
    }

    @Test
    public void getProductByNonExistingId() throws Exception{
        //Arrange
        String id = "999";
        when(repository.findById(id)).thenReturn(null);

        //Act
        Product result = service.getProductById(id);

        //Assert
        assertNull(result);
    }

    @Test
    public void updateExistingProduct() throws Exception{
        //Arrange
        String id = "1";
        when(repository.findById(id)).thenReturn(p1);
        when(repository.save(p1)).thenReturn(p1);

        //Act
        Product result = service.updateProduct(id, p1);

        //Assert
        assertNotNull(result);
        assertEquals(p1, result);
    }

    @Test
    public void updateNonExistingProduct() throws Exception{
        //Arrange
        String id = "999";
        when(repository.findById(id)).thenReturn(null);

        //Act
        Product result = service.updateProduct(id, null);

        //Assert
        assertNull(result);
    }

}
