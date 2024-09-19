import models.Persona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona persona1 = new Persona("Juan", 25, "12345678A");
        Persona persona2 = new Persona("Pedro", 35, "87654321B", 1.80, 80);

        // This will throw an error because the constructor with 3 parameters is not defined
        //Persona persona3 = new Persona("Maria", 35);

        imprimirDetallesDePersona(persona2);
    }

    private static void imprimirDetallesDePersona(Persona persona) {
        System.out.println(persona.toString());
        System.out.println(formatearMensajeIMC(persona.calcularIMC()));
        System.out.println("Es mayor de edad: " + persona.esMayorDeEdad());
    }

    private static String formatearMensajeIMC(int imc) {
        switch (imc) {
            case -1:
                return "Bajo peso";
            case 0:
                return "Peso saludable";
            case 1:
                return "Sobrepeso";
            default:
                return "IMC no calculado.";
        }
    }
}