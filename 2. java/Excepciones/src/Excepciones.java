public class Excepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        try {
            double resultado = b/a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        finally {
            System.out.println("Programa finalizado.");
        }
    }
}