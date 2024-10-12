package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {
    RomanNumeralsRestController romanNumeralsRestController;
    @BeforeEach
     void beforeEach() {
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

@DisplayName("UNIT TEST : 1 = I")
    @Test
    void toRomanI() {
    Integer number = 1;
    String expected = "I";

    String response = romanNumeralsRestController.toRoman(number);

    assertEquals(expected,response);
    }

    @DisplayName("UNIT TEST : 3 = III")
    @Test
    void toRomanIII() {
        Integer number = 3;
        String expected = "III";

        String response = romanNumeralsRestController.toRoman(number);

        assertEquals(expected,response);
    }
    @DisplayName("UNIT TEST : 5 = V")
    @Test
    void toRomanV() {
        Integer number = 5;
        String expected = "V";

        String response = romanNumeralsRestController.toRoman(number);

        assertEquals(expected,response);
    }
    @DisplayName("UNIT TEST : 7 = VII")
    @Test
    void toRomanVII() {
        Integer number = 7;
        String expected = "VII";

        String response = romanNumeralsRestController.toRoman(number);

        assertEquals(expected,response);
    }
    @DisplayName("UNIT TEST : 10 = X")
    @Test
    void toRoman() {
        Integer number = 10;
        String expected = "X";

        String response = romanNumeralsRestController.toRoman(number);

        assertEquals(expected,response);
    }
    @DisplayName("UNIT TEST : 50 = L")
    @Test
    void toRomanL() {
        Integer number = 50;
        String expected = "L";

        String response = romanNumeralsRestController.toRoman(number);

        assertEquals(expected,response);
    }
}