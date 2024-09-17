public class Main {
    public static void main(String[] args) {


        String mensajeFinal = "Programa Finalizado";

        int a = 0;
        int b = 300;
        double cociente;

        try {
            cociente = b/a;
            System.out.println("El resultado fue: " + cociente);
        } catch(Exception exception){
            System.out.println("Se ha producido un error");
            //throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println(mensajeFinal);
        }

    }


}