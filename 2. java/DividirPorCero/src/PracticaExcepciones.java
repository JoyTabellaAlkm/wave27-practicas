public class PracticaExcepciones {
    private final int a = 0;
    private final int b = 300;

    public double calcularCociente() {
        try {
            double resultado = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }
        return 0;
    }

    public double calcularCociente2() throws IllegalArgumentException {
        if (a == 0) throw new IllegalArgumentException("No se puede dividir por cero.");
        else
            return b / a;

    }
}
