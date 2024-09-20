package org.example;

public class Main {
    public static String nivelPeso(int imc, boolean esMayor){

        if (!esMayor){return "Es menor de edad";}

        if (imc == -1){return "Bajo Peso";}

        if (imc == 0){return "Peso Saludable";}

        return "Sobrepeso";
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("mati", 23, "12332134");
        Persona persona3 = new Persona("fernando", 23, "43244297", 70.0f, 160);

        System.out.println(persona3);
        System.out.println(nivelPeso(persona3.CalcularIMC(), persona3.esMayor()));
    }
}