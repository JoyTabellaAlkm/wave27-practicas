package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindController {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FindService findService;

    @Autowired
    private CharacterRepositoryImpl characterRepository;

    @Test
    public void findReturnsOk() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CharacterDTO characterDTO = new CharacterDTO(
                "R2-D2",
                "NA",
                "white, blue",
                "red",
                "33BBY",
                "NA",
                "Naboo",
                "Droid",
                96,
                32
        );

        mockMvc.perform(get("/R2-D2").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(characterDTO)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$.[*].name").value("R2-D2"));
    }

    @Test
    public void findReturnsOkWithEmptyList() throws Exception {
        mockMvc.perform(get("/helloWorld")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
