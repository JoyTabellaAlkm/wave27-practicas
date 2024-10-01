package com.company;

public class Main {

    public static void main(String[] args) {

        Persona persona1= new Persona();
        Persona persona2= new Persona("José", 28, "3055969053");
        Persona persona3= new Persona("Juan",35,"04394594593",60,170);


        int indice=persona3.cacularIMC();

        switch (indice){
            case -1:
                System.out.println(persona3.getNombre() +" tiene Bajo Peso");
                break;
            case 0:
                System.out.println(persona3.getNombre() +" tiene Peso Saludable");
                break;
            case 1:
                System.out.println(persona3.getNombre() +" tiene Sobrepeso");
                break;
            default:
                System.out.println("Error al obtener el índice");
        }

        if(persona3.esMayorDeEdad()){
            System.out.println(persona3.getNombre() + " es mayor de edad");
        }
        else System.out.println(persona3.getNombre() + " es menor de edad");

        System.out.println(persona3.toString());
    }
}
