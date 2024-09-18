public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 25, "12345678A");
        Persona persona3 = new Persona("Pedro", 35, "87654321B", 70, 1.75);
        // Esto da error porque no existe un constructor con esos parámetros
        //Persona persona4 = new Persona("Ana", 35);

        System.out.println(formatearIMC(persona3.calcularIMC()));
        System.out.println("La persona es mayor de edad: " + persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
    }

    private static String formatearIMC(int imc) {
        switch (imc) {
            case -1:
                return "Bajo peso";
            case 0:
                return "Peso saludable";
            case 1:
                return "Sobrepeso";
            default:
                return "Valor no válido";
        }
    }
}