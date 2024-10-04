package ar.com.mercadolibre.ecommerce.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ar.com.mercadolibre.ecommerce.models.Product;
import ar.com.mercadolibre.ecommerce.repositories.ProductRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        //productRepository.loadProducts();
    }

    @Test
    public void testCreateProduct() throws Exception {
        String jsonProduct = "{\"name\":\"Product 1\", \"description\":\"Description 1\", \"price\":10.0}";

        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content(jsonProduct))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Product 1")));
    }

    @Test
    public void testFindById() throws Exception {
        Product newProduct = new Product(null, "Product 2", 20.0);
        Product savedProduct = productRepository.save(newProduct);

        mockMvc.perform(get("/products/" + savedProduct.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(savedProduct.getName())));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        mockMvc.perform(get("/products/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAll() throws Exception {

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }


}
