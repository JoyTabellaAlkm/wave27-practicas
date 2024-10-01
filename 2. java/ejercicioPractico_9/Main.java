public class Main {

    public static void main(String[] args) {
        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        try {
            //Código que arroja excepción
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch(Exception exception){
            System.out.println("Se ha producido un error: " + exception.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}