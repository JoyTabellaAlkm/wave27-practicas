public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAbonar;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.montoAbonar = categoria.getPrecio(participante.getEdad());
    }

    public Participante getParticipante() {
        return participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getMontoAbonar() {
        return montoAbonar;
    }

    @Override
    public String toString() {
        return "Inscripción N°: " + numeroInscripcion + " - Participante: " + participante + " - Monto a abonar: $" + montoAbonar;
    }
}
