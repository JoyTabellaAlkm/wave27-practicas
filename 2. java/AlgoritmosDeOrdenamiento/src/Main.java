
public class Main {
    public static int[] burbuja (int[] array){
        int length = array.length;
        boolean intercambio;

        for (int paso = 0; paso < length - 1; paso++)
        {
            intercambio=false;
            for (int i = 0; i < length - paso - 1; i++)
            {
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    intercambio = true;

                }
            }
            if(!intercambio) break;
        }
        return  array;
    }


    public static void main(String[] args) {
        int[] array = {1,3,59,6,3,2,7,10,33,45};
    burbuja(array);
    imprimirArray(array);
    }
    public static void imprimirArray(int[] array){
        for(int e : array){
            System.out.println("Elemento: " + e);
        }
    }
}