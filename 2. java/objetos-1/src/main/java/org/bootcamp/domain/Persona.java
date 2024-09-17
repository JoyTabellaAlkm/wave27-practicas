package org.bootcamp.domain;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC() {
        double imc = peso / Math.pow(altura, 2);

        if (imc < 20)
            return -1;

        if (imc <= 25)
            return 0;

        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return """
                Persona {
                    Nombre: '%s',
                    Edad: %d,
                    DNI: '%s',
                    Peso: %.2f,
                    Altura: %.2f
                }
                """.formatted(nombre, edad, dni, peso, altura);
    }
}
