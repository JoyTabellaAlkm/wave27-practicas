package com.mercadolibre.starwars.integrationTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Test
    @DisplayName("Find Query")
    public void findHappyPath() throws Exception {
        String query = "C-3PO";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("C-3PO"))
                .andReturn();
    }

    @Test
    @DisplayName("Find Query Exception")
    public void findBadPath() throws Exception {
        String query = "Camaleon";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty()) // Porque tengo un array vacio y ningun atributo que comparar
                .andReturn();
    }
}
