public class SerieDeDos extends SerieNumerica{

    public SerieDeDos() {
        super(2, 2); // Valor inicial 2 y incremento 2
    }

    @Override
    protected Integer calcularValor(int contador) {
        return valorInicial.intValue() + (incremento * contador);
    }
}
