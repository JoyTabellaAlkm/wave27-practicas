package domain;

public class CircuitoMedio extends Categoria {
    public CircuitoMedio(int id) {
        super(id, Categoria.NOMBRE_MEDIO, "5 km por selva, arroyos y barro.");
    }

    @Override
    public int calcularMonto(int edadParticipante) {
        return edadParticipante < 18 ? 2000 : 2300;
    }
}
