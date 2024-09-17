package POO2.Ejercicio1;

public class MainEj1 {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int c = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
