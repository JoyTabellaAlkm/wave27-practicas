public class Inscripcion {
    double costoInscripcion;
    Participante participante;

    public Inscripcion(double costoInscripcion, Participante participante) {
        this.costoInscripcion = costoInscripcion;
        this.participante = participante;
    }
    public double getCostoInscripcion() {
        return costoInscripcion;
    }
    public void setCostoInscripcion(double costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }
    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                ", costoInscripcion=" + costoInscripcion +
                ", participante=" + (participante != null ? participante.toString() : "null") +
                '}';
    }
}
