package com.mercadolibre.romannumerals.unit;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsrestControllerTest {
    RomanNumeralsRestController romanNumeralsRestController = new RomanNumeralsRestController();

    @Test
    void oneTest(){
        //Arrange
        Integer number = 1;
        String romanExpected = "I";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void threeTest(){
        //Arrange
        Integer number = 3;
        String romanExpected = "III";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void fiveTest(){
        //Arrange
        Integer number = 5;
        String romanExpected = "V";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void sevenTest(){
        //Arrange
        Integer number = 7;
        String romanExpected = "VII";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void nineTest(){
        //Arrange
        Integer number = 9;
        String romanExpected = "IX";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void tenTest(){
        //Arrange
        Integer number = 10;
        String romanExpected = "X";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }

    @Test
    void fiftyTest(){
        //Arrange
        Integer number = 50;
        String romanExpected = "L";

        //Act
        String romanObtained = romanNumeralsRestController.toRoman(number);

        //Assert
        Assertions.assertEquals(romanExpected, romanObtained);
    }
}
