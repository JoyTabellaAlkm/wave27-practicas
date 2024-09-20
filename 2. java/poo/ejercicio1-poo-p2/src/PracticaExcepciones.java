public class PracticaExcepciones {
    private int a =0;
    private int b = 300;

 public double calcularCociente() throws IllegalArgumentException{

         if( a == 0) throw new IllegalArgumentException("No se puede dividir por cero.");
         else
         return b/a;

 }
}
