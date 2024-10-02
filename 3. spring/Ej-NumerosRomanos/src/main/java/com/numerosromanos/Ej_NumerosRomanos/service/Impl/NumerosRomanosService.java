package com.numerosromanos.Ej_NumerosRomanos.service.Impl;
import com.numerosromanos.Ej_NumerosRomanos.service.INumerosRomanos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumerosRomanosService implements INumerosRomanos {

    @Override
    public String numRomano(Integer numero) {
        String resultado = "";
        int[] numbersToCompare = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i< numbersToCompare.length; i++) {
            while (numero >= numbersToCompare[i]){
                resultado += romanNumbers[i];
                numero -= numbersToCompare[i];
            }
        }
        return "El número en romano es " + resultado;
    }
}
