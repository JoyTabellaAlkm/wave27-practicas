public class Temperatura {

    String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago" +
            "de Chile", "Lisboa","Tokio"};

    int[][] temperatura= {
            {2, 33},
            {3, 32},
            {8, 27},
            {4, 37},
            {6, 42},
            {5, 43},
            {0, 39},
            {7, 26},
            {1, 31},
            {10, 35}
    };

    public void ejercicio(){
        int numeroMenor = 0;
        int numeroMayor = 0;
        String ciudadMenor = "";
        String ciudadMayor = "";

        for (int i=0; i < ciudades.length; i++) {

            if (temperatura[i][0] < numeroMenor) {
                numeroMenor = temperatura[i][0];
                ciudadMenor = ciudades[i];
            }

            if (temperatura[i][1] > numeroMayor){
                numeroMayor = temperatura[i][1];
                ciudadMayor = ciudades[i];
            }

        }

        System.out.println("La ciudad con menor temperatura es: " + ciudadMenor + "." + " Su temperatura es: " + numeroMenor);
        System.out.println("La ciudad con mayor temperatura es: " + ciudadMayor + "." + " Su temperatura es: " + numeroMayor);
    }
}
