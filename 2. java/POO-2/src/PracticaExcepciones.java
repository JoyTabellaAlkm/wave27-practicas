public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void calcularCociente() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }

            double res = Math.cos(b / a);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
