//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile",
                "Lisboa", "Tokio"};

        int[][] temperatura = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int numeroMenor = 0;
        int numeroMayor = 0;
        String ciudadMenor = "";
        String ciudadMayor = "";

        for (int i=0; i < ciudades.length; i++){

            if (i==0){
                numeroMenor = temperatura[i][0];
                numeroMayor= temperatura[i][1];
                ciudadMenor = ciudades[i];
                ciudadMayor = ciudades[i];
            }
            else{
                if (numeroMenor > temperatura[i][0]){
                    numeroMenor = temperatura[i][0];
                    ciudadMenor = ciudades[i];

                }
                if (numeroMayor < temperatura[i][1]){
                    numeroMayor = temperatura[i][1];
                    ciudadMayor = ciudades[i];
                }
            }
        }

        System.out.println("La temperatura menor es: " + numeroMenor + " La ciudad es: " + ciudadMenor);
        System.out.println("La temperatura mayor es: " + numeroMayor + " La ciudad es: " + ciudadMayor);


    }
}