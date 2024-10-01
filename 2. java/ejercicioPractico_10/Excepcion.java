/*
* * Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
 *  Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
 * “Se ha producido un error”. Al final del programa siempre deberá indicar el
 * mensaje “Programa finalizado” Modificar el programa anterior para que,
 * al producirse el error, en vez de imprimir por consola el mensaje
 * “Se ha producido un error”, lo lance como una excepción de
 * tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”
 *
* */
public class Excepcion {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int cociente = b/a;
            System.out.println("El resultado es: " + cociente);
        }catch(Exception exception){
            //System.out.println("Se ha producido un error: " + exception.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}