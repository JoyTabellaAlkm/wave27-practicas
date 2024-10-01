package com.company;

public class PracticaExcepciones {
    int a =0;
    int b=300;

    public double calcularCociente() throws IllegalArgumentException{

        if( a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        else
            return b/a;

    }
}
