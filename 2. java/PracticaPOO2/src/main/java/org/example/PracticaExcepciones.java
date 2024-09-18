package org.example;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void caculateQuotient(){
        try {
            if ( a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int result = a/b;
            System.out.println("El resultado es : " + result);
        } catch (IllegalArgumentException e) {
            //System.out.println("Se ha producido un error: " + e.getMessage());
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
