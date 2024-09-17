public class Main {
    public static void main(String[] args) {

//        Persona mati = new Persona();
//        Persona juan = new Persona("Juan", 21, "43452021");
//        Persona martin = new Persona("Martin", 21, "43452020", 85, 180);
//
//        System.out.println(nivelPeso(martin.calcularIMC(), martin.esMayor()));
//        System.out.println(martin);

        //Mensaje final
        String mensajeFinal = "Programa finalizado";
        int a = 300;
        int b = 0;
        double cociente;

        try {
            cociente = a/b;
         }catch (Exception e){
            System.out.println("Se produjo un error");
        }finally {
            System.out.println(mensajeFinal);
        }

        }

    public static String nivelPeso(int imc, boolean esMayor){

        if (!esMayor){return "Es menor de edad";}

        if (imc == -1){return "Bajo Peso";}

        if (imc == 0){return "Peso Saludable";}

        return "Sobrepeso";
    }

}
