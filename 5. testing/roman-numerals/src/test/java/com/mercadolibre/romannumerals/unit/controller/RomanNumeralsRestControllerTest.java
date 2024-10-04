package com.mercadolibre.romannumerals.unit.controller;


import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumeralsRestControllerTest {

    @Autowired
    RomanNumeralsRestController controller;

    @Test
    public void testIOk(){
        performTest(1, "I");
    }

    @Test
    public void testIIIOk(){
        performTest(3, "III");
    }

    @Test
    public void testVOk(){
        performTest(5, "V");
    }

    @Test
    public void testVIIOk(){
        performTest(7, "VII");
    }

    @Test
    public void testXOk(){
        performTest(10, "X");
    }

    @Test
    public void testLOk(){
        performTest(50, "L");
    }

    public void performTest(int number, String expected){
        String result = controller.toRoman(number);
        assertEquals(expected, result);
    }

}
