import model.Persona;

public class Main {
    public static void main(String[] args) {
        // Crear objetos de la clase Persona
        Persona perso1 = new Persona();
        Persona perso2 = new Persona("Juan", 25, "12345678A");
        Persona perso3 = new Persona("Maria", 19, "87654321B", 70.0, 1.70);

        // Variables para almacenar los mensajes de IMC y mayor de edad
        String mensajeIMC;
        String mensajeMayorEdad;

        // Imprimir los datos de las personas
        System.out.println("Calculadora de IMC y mayor de edad");
        System.out.println("====================================");
        if(perso3.calcularIMC() == -1){
            mensajeIMC = "Bajo peso";
        } else if(perso3.calcularIMC() == 0){
            mensajeIMC = "Peso normal";
        } else {
            mensajeIMC = "Sobrepeso";
        }
        System.out.println("El IMC de la persona " + perso3.getNombre() + " es: " + mensajeIMC);
        System.out.println("====================================");

        if(perso3.esMayorDeEdad()){
            mensajeMayorEdad = "Es mayor de edad";
        } else {
            mensajeMayorEdad = "Es menor de edad";
        }
        System.out.println("La persona " + perso3.getNombre() + " tiene " + perso3.getEdad() + " años y " + mensajeMayorEdad);
    }

}