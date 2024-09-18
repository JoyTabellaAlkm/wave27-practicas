package ej1;

public class Ejercicio1 {

    public static int[] burbuja(int[] array) {
        int n = array.length;
        boolean intercambio;

        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;
            for (int i = 0; i < n - paso - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // Intercambiar array[i] y array[i + 1]
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }
            // Si no hubo intercambio, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] arrayOrdenado = burbuja(array);
        imprimirArreglo(arrayOrdenado);
    }

    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
    }
}