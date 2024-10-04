public class JP1_Temperatura {
    public static void main(String[] args) {
        //Declaración e inicializacion de los datos
        String[] ciudades = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santigo de chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2,-3,-8,4,6,5,0,-7,-1,-10},{33,32,27,37,42,43,39,26,31,35}};

        //Declaracion de variables de control
        int max = 0 , min = 0, posMin =0, posMax=0;
        for (int i = 0; i < 10; i++) {
            //comprobacion menor
            if (temperaturas[0][i] < min){
                min = temperaturas[0][i];
                posMin = i;
            }
            //comprobacion mayor
            if (temperaturas[1][i] > max){
                max = temperaturas[1][i];
                posMax = i;
            }
        }
        //Mostrar los resultados
        System.out.println("La ciudad con la menor temperatura es: " + ciudades[posMin]);
        System.out.println("La ciudad con la mayor temperatura es: " + ciudades[posMax]);

    }
}