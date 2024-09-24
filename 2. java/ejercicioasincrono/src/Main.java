public class Main {
    public static void main(String[] args) {
        System.out.println("serie 2");
        Serie2 serie2 = new Serie2();
        serie2.establecerValorInicial(2);
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());
        System.out.println("se reinicia");
        serie2.reiniciarSerie();
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());
        System.out.println(serie2.devolverNumero());

        System.out.println("serie 3");
        Serie3 serie3 = new Serie3();
        serie3.establecerValorInicial(2);
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());
        System.out.println("se reinicia");
        serie3.reiniciarSerie();
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());
        System.out.println(serie3.devolverNumero());

    }
}