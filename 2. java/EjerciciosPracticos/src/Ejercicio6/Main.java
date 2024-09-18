package Ejercicio6;

public class Main
{
    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

//Código que arroja excepción
        int[] numeros = new int[5];

        try{
            numeros[5] = 10;

        } catch (IndexOutOfBoundsException e){
            System.out.println("Error, el indice al que se desea acceder sobrepasa la capacidad del array | " + e.getMessage() );

        } finally {
            System.out.println(mensajeFinal);
        }
    }
}
