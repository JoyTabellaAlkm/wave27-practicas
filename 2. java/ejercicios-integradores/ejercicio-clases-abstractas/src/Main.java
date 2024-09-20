public class Main {
    public static void main(String[] args) {
        SerieDeDos serieDos = new SerieDeDos();
        SerieDeTres serieTres = new SerieDeTres();

        System.out.println("Serie de dos:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.devolverValorSiguiente());
        }

        serieDos.establecerValorInicial(1);
        System.out.println("Serie de dos con valor inicial 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieDos.devolverValorSiguiente());
        }

        System.out.println("\nSerie de tres:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieTres.devolverValorSiguiente());
        }

        serieTres.establecerValorInicial(1);
        System.out.println("Serie de tres con valor inicial 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieTres.devolverValorSiguiente());
        }
    }
}