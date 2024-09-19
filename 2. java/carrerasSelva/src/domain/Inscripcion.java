package domain;

import exception.InvalidCategoryException;
import exception.ParticipantUnderAgeException;

public class Inscripcion {
    private int nro;
    private Categoria categoria;
    private Participante participante;
    private double montoAPagar;

    public Inscripcion(int nro, Categoria categoria, Participante participante) {
        this.nro = nro;
        this.participante = participante;
        this.setCategoria(categoria);
        this.montoAPagar = calcularMontoAPagar(participante.getEdad(), categoria.getNombre());
    }

    private void setCategoria(Categoria categoria) {
        categoria.inscribirParticipante(this.participante);
        this.categoria = categoria;
    }
    private int calcularMontoAPagar(int edadParticipante, String nombreCategoria) {
        int monto;

        switch (nombreCategoria) {
            case Categoria.NOMBRE_CIRCUITO_CHICO:
                monto = edadParticipante < 18 ? 1300 : 1500;
                break;

            case Categoria.NOMBRE_CIRCUITO_MEDIO:
                monto = edadParticipante < 18 ? 2000 : 2300;
                break;

            case Categoria.NOMBRE_CIRCUITO_AVANZADO:
                monto = edadParticipante < 18 ? -1 : 2800;
                break;

            default:
                monto = -2;
                break;
        }

        if (monto == -1) {
            throw new ParticipantUnderAgeException("El participante tiene menos de 18 años");
        }

        if (monto == -2) {
            throw new InvalidCategoryException("La categoría no existe");
        }

        return monto;
    }

    public void desinscribir() {
        this.categoria.desinscribirParticipante(this.participante.getNro());
        this.participante = null;
    }
}
