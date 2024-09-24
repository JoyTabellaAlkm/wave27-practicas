package com.mercadolibre.convertidorRomanos.services.impl;

import com.mercadolibre.convertidorRomanos.services.IConvertirRomanoServices;
import org.apache.tomcat.util.http.parser.Ranges;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.*;
@Service
public class ConvertirRomanoServices implements IConvertirRomanoServices {

    public String calcularRomano(int numeroDecimal){
        Map<String, Integer>  romanosMap = new LinkedHashMap<>();
        romanosMap.put("M",1000);
        romanosMap.put("CM",900);
        romanosMap.put("D",500);
        romanosMap.put("CD",400);
        romanosMap.put("C",100);
        romanosMap.put("XC",90);
        romanosMap.put("L",50);
        romanosMap.put("XL",40);
        romanosMap.put("X",10);
        romanosMap.put("IX",9);
        romanosMap.put("V",5);
        romanosMap.put("IV",4);
        romanosMap.put("I", 1);

        String resultNumeroEnRomano="";


       for(Map.Entry<String,Integer> recorrer : romanosMap.entrySet()){
          int numeros= recorrer.getValue();
           String simbolos = recorrer.getKey();
          while(numeroDecimal >= numeros){
              resultNumeroEnRomano +=simbolos;
              numeroDecimal -= numeroDecimal;

          }
       }

       return resultNumeroEnRomano;
    }
    @Override
    public String obtenerRomano(int numeroDecimal) {
        return calcularRomano(numeroDecimal);
    }




}
