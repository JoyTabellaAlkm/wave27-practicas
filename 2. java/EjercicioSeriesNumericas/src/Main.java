public class Main {
    public static void main(String[] args) {
        SerieDos serie2 = new SerieDos();
        System.out.println("DEFINICIÓN DE SERIE 2.");
        serie2.definirSerie();
        for (int i = 0; i < 5; i++){
            System.out.println(serie2.mostrarSerie());
        }
        serie2.reiniciarSerie(1);
        for (int i = 0; i < 5; i++){
            System.out.println(serie2.mostrarSerie());
        }

        SerieTres serie3 = new SerieTres();
        System.out.println("DEFINICIÓN DE SERIE 3.");
        serie3.definirSerie();
        for (int i = 0; i < 5; i++){
            System.out.println(serie3.mostrarSerie());
        }
        serie3.reiniciarSerie(1);
        for (int i = 0; i < 5; i++){
            System.out.println(serie3.mostrarSerie());
        }

    }
}