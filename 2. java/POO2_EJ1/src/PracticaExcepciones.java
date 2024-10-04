public class PracticaExcepciones {
    private int a = 0, b = 300;


    public PracticaExcepciones() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            System.out.println(Math.cos(b / a));
        } catch (IllegalArgumentException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
