package org.bootcamp;

import org.bootcamp.domain.Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaSinNombre = new Persona();
        Persona juan = new Persona("Juan", 30, "12.345.678");
        Persona luis = new Persona("Luis", 25, "23.456.789", 80.2d, 1.93d);
        // Si tratamos de agegar un constructor con 2 parámetros (nombre y edad) no va a compilar porque no hay un constructor con esos parámetros

        String imcLuis = switch (luis.cacularIMC()) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso normal";
            case 1 -> "Sobrepeso";
            default -> "IMC no calculado";
        };
        System.out.printf("IMC Luis: %s\n", imcLuis);
        System.out.printf("Luis %s es mayor de edad.\n", luis.esMayorDeEdad() ? "sí" : "no");
        System.out.printf("Información de Luis: \n%s", luis);
    }
}