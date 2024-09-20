package org.example;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private Float peso;
    private Integer alturaCm;

    public Persona() {
        nombre = "";
        edad = 0;
        dni = "";
        peso = 0.0f;
        alturaCm = 0;
    }

    public Persona(String nombre, Integer edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Float peso, Integer alturaCm) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.alturaCm = alturaCm;
    }

    public Integer CalcularIMC(){
        double imc = peso / Math.pow((double) alturaCm / 100, 2);
        if (imc < 20){
            return -1;
        }

        if (imc <= 25){
            return  0;
        }

        return 1;
    }

    public boolean esMayor(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " - Edad: " + edad +
                " - DNI: " + dni +
                " - Peso:" + peso +
                " - Altura:" + alturaCm +
                " - IMC: " + CalcularIMC();
    }
}
