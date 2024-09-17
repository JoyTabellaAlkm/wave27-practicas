package domain;

import exception.InvalidParticipantException;

public class CircuitoAvanzado extends Categoria {
    public CircuitoAvanzado(int id) {
        super(id, Categoria.NOMBRE_AVANZADO, "10 km por selva, arroyos, barro y escalada en piedra.");
    }

    @Override
    public int calcularMonto(int edadParticipante) {
        if (edadParticipante < 18) {
            throw new InvalidParticipantException("Los menores de 18 años no pueden hacer el circuito avanzado");
        }

        return 2800;
    }
}
