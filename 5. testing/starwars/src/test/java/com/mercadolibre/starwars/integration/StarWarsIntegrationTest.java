package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findExistingNameTest() throws Exception{
        String query = "Luke Skywalker";
        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query)
                .accept("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Luke Skywalker"))
                .andExpect(status().isOk());
    }

    @Test
    public void findExistingNamesTest() throws Exception{
        String query = "Darth";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query)
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(status().isOk());
    }

    @Test
    public void findNonExistingNamesTest() throws Exception{
        String query = "Mati";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query)
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0))
                .andExpect(status().isOk());
    }

}

