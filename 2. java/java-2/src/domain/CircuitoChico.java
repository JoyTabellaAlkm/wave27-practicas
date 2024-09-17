package domain;

public class CircuitoChico extends Categoria {
    public CircuitoChico(int id) {
        super(id, Categoria.NOMBRE_CHICO, "2 km por selva y arroyos.");
    }

    @Override
    public int calcularMonto(int edadParticipante) {
        return edadParticipante < 18 ? 1300 : 1500;
    }
}
