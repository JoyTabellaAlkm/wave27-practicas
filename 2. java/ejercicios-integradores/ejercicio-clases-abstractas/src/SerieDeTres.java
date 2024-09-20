public class SerieDeTres extends SerieNumerica{
    public SerieDeTres() {
        super(3, 3); // Valor inicial 3 e incremento 3
    }

    @Override
    protected Integer calcularValor(int contador) {
        return valorInicial.intValue() + (incremento * contador);
    }
}
