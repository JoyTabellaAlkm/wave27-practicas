package com.mercadolibre.ejercicionumerosromanos.services;

import com.mercadolibre.ejercicionumerosromanos.services.impl.IConvertirNumero;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NumeroRomanoService implements IConvertirNumero {
    @Override
    public String convertirNumeroDecimalARomano(int numeroDecimal) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<Integer,String> entry: obtenerMapaDeNumerosRomanos().entrySet()){
            int valor = entry.getKey();
            String simbolo = entry.getValue();
            while(numeroDecimal >= valor){
                stringBuilder.append(simbolo);
                numeroDecimal -= valor;
            }
        }
        return stringBuilder.toString();
    }

    private static Map<Integer, String> obtenerMapaDeNumerosRomanos() {
        Map<Integer,String> numerosRomanosYDecimales = new LinkedHashMap<>();
        numerosRomanosYDecimales.put(1000,"M");
        numerosRomanosYDecimales.put(900,"CM");
        numerosRomanosYDecimales.put(500,"D");
        numerosRomanosYDecimales.put(400,"CD");
        numerosRomanosYDecimales.put(100,"C");
        numerosRomanosYDecimales.put(90,"XC");
        numerosRomanosYDecimales.put(50,"L");
        numerosRomanosYDecimales.put(40,"XL");
        numerosRomanosYDecimales.put(10,"X");
        numerosRomanosYDecimales.put(9,"IX");
        numerosRomanosYDecimales.put(5,"V");
        numerosRomanosYDecimales.put(4,"IV");
        numerosRomanosYDecimales.put(1,"I");
        return numerosRomanosYDecimales;
    }

}
