package POO1;

public class POO1_Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678A");
        Persona persona3 = new Persona("Maria", 30, "87654321B", 70.0, 1.70);

        //No es posible. No existe constructor con los parámetros indicados

        System.out.print(persona3.getNombre() + " tiene: ");

        int nivelDePeso = persona3.calcularIMC();

        if(nivelDePeso == -1) {
            System.out.println("Bajo peso");
        } else if(nivelDePeso == 0) {
            System.out.println("Peso saludable");
        } else {
            System.out.println("Sobrepeso");
        }

        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad");

        System.out.println(persona3.toString());

    }

}
