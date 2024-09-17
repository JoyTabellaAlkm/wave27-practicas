package P1;

import java.util.Arrays;

public class P1 {
    public static void main(String Args[]){
        System.out.println("Hello, world");

        String ciudadesDelMundo[] = {"Londres","Madrid", "New York", "tokyo"};
        int tempMaxYMin[][] = {{1,2},{-1,4},{2,3}, {-10,3}};
        int indiceMinTemp = 0;
        int indiceMaxTemp = 0;

        for (int index = 0; index < ciudadesDelMundo.length; index++){
            if(tempMaxYMin[index][0] < tempMaxYMin[indiceMinTemp][0]){
                indiceMinTemp = index;
            }
            if(tempMaxYMin[index][1] > tempMaxYMin[indiceMaxTemp][1]){
                indiceMaxTemp = index;
            }
        }

        System.out.println("La ciudad con menor temperatura fue: " + ciudadesDelMundo[indiceMinTemp] + " con: " + tempMaxYMin[indiceMinTemp][0] + " grados");
        System.out.println("La ciudad con mayor temperatura fue: " + ciudadesDelMundo[indiceMaxTemp] + " con: " + tempMaxYMin[1][indiceMaxTemp] + " grados");
    }
}
