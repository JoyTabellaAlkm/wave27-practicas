package com.ejercicios.numerosromanos.service;

import org.springframework.stereotype.Service;

@Service
public class NumerosRomanosService {

    public String transformarNumeros(int numero){
        int[] numerosEnteros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder resultado = new StringBuilder();
        for(int i =0 ; i<numerosEnteros.length;i++){
            while(numero>= numerosEnteros[i]){
                resultado.append(numerosRomanos[i]);
                numero  -= numerosEnteros[i];
            }
        }
        return resultado.toString();
    }
}
