public abstract class Prototipo {
    private int siguienteSerie;
    private static Integer valorSerie = 0;


    public void definirSerie(Integer valorInicial) {
        valorSerie = valorInicial;
        System.out.println("Valor inicial de la serie definido: "+valorInicial);
    }

    public Integer mostrarSerie(){
        siguienteSerie += valorSerie;
        return siguienteSerie;
    }

    public void reiniciarSerie(Integer valorInicial){
        siguienteSerie = valorInicial;
        System.out.println("Serie reiniciada en " +valorInicial);
    }
}
