package Ejercicio2;
//Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int. Calcular el cociente de b/a.
// Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre
// deberá indicar el mensaje “Programa finalizado”
//Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje
// “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje
// “No se puede dividir por cero”
public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        a = 0;
        b = 300;
    }

    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }

    public void calcular()
    {
        try{
            //Cuando casteamos no muestra la exception
            double resultado = getB() / getA();
            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}
