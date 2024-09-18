public class Excepcion {
    public static void main(String[] args){
        try {   //Mensaje final
            String mensajeFinal = "Este es el último mensaje";

            //Código que arroja excepción
            int[] numeros = new int[5];
            numeros[5] = 10;

            System.out.println(mensajeFinal);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
