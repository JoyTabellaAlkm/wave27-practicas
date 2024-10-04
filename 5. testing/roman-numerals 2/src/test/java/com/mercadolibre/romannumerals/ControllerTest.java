package com.mercadolibre.romannumerals;

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
    @DisplayName("Happy Path case 1")
    public void romans1() throws Exception{
        int number = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("I"))
                .andReturn();
    }

    @Test
    @DisplayName("Happy Path case 2")
    public void romans2() throws Exception{
        int number = 3;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("III"))
                .andReturn();
    }

    @Test
    @DisplayName("Happy Path case 3")
    public void romans3() throws Exception{
        int number = 5;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("V"))
                .andReturn();
    }

    @Test
    @DisplayName("Happy Path case 4")
    public void romans4() throws Exception{
        int number = 7;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("VII"))
                .andReturn();
    }

    @Test
    @DisplayName("Happy Path case 5")
    public void romans5() throws Exception{
        int number = 10;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("X"))
                .andReturn();
    }

    @Test
    @DisplayName("Happy Path case 6")
    public void romans6() throws Exception{
        int number = 50;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value("L"))
                .andReturn();
    }

    @Test
    @DisplayName("Sad Path negative")
    public void romansNegative() throws Exception{
        int number = -50;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    @DisplayName("Sad Path")
    public void romansBad() throws Exception{
        String number = "numero";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/{number}", number).accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();
    }
}
