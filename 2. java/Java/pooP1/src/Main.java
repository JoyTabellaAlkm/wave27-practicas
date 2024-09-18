public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Carla", 32, "12345678");
        Persona persona3 = new Persona("Tamara", 56, "87654321", 84.7, 1.90);

        int imc = persona3.calcularIMC();
        boolean mayor = persona3.esMayorDeEdad();
        String persona = persona3.toString();

        if (imc == -1 && mayor){
            System.out.println("Por debajo de 20: " + "Bajo Peso. " + "Es mayor de edad. " + persona);
        }
        else if (imc == 0 && mayor){
            System.out.println("Entre 20 y 25: " + "Peso Saludable. " + "Es mayor de edad. " + persona);
        }
        else if (imc == 1 && mayor){
            System.out.println("Mayor de 25: " + "Sobrepeso. " + "Es mayor de edad. " + persona);
        }
        else if (imc == -1 && mayor == false){
            System.out.println("Por debajo de 20: " + "Bajo Peso. " + "Es menor de edad. " + persona);
        }
        else if (imc == 0 && mayor == false){
            System.out.println("Entre 20 y 25: " + "Peso Saludable. " + "Es menor de edad. " + persona);
        }
        else{
            System.out.println("Mayor de 25: " + "Sobrepeso. " + "Es menor de edad. " + persona);
        }


    }
}