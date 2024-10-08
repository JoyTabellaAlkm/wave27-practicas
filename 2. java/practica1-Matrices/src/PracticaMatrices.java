public class PracticaMatrices {
    String ciudades[] = new String[10];
    int matriz[][] = new int[10][2];

    public String determinarTemperaturas() {
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        matriz[0][0] = -2;
        matriz[0][1] = 33;
        matriz[1][0] = -3;
        matriz[1][1] = 32;
        matriz[2][0] = -8;
        matriz[2][1] = 27;
        matriz[3][0] = 4;
        matriz[3][1] = 37;
        matriz[4][0] = 6;
        matriz[4][1] = 42;
        matriz[5][0] = 5;
        matriz[5][1] = 43;
        matriz[6][0] = 0;
        matriz[6][1] = 39;
        matriz[7][0] = -7;
        matriz[7][1] = 26;
        matriz[8][0] = -1;
        matriz[8][1] = 31;
        matriz[9][0] = -10;
        matriz[9][1] = 35;

        int baja = matriz[0][0];
        int alta = matriz[0][1];
        String ciudadBaja = ciudades[0];
        String ciudadAlta = ciudades[0];

        for (int i = 1; i < ciudades.length; i++) {
            if (matriz[i][0] < baja) {
                baja = matriz[i][0];
                ciudadBaja = ciudades[i];
            }
            if (matriz[i][1] > alta) {
                alta = matriz[i][1];
                ciudadAlta = ciudades[i];
            }
        }

        return "La ciudad con la temperatura más baja es: " + ciudadBaja + "\nLa ciudad con la temperatura más alta es: " + ciudadAlta;
    }
}
