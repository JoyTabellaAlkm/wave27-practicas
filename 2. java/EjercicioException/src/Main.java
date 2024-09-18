public class Main {
    public static void main(String[] args) {
            //Mensaje final
            String mensajeFinal = "Este es el último mensaje";

//Código que arroja excepción
            int[] numeros = new int[5];

            try{
                numeros[5] = 10;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Verifique el indice del array al que quiere acceder: " + e.getMessage());
            }finally{
                System.out.println(mensajeFinal);
            }
    }
}