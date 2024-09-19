package prototipo;

public class ProgresionEnteros<T extends Integer> extends Prototipo {

    public ProgresionEnteros(int num) {
        super(num);
    }

    @Override
    public Number devolverValorSiguiente(Number num1, Number num2) {
        return num1 + num2;
    }

    @Override
    protected void setValorInicial(Number num) {

    }
}
