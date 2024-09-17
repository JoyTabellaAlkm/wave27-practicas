package carreraDeLaSelva;

public class Inscripcion {

    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int montoAbonar;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante){
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.calcularMonto();
    }

    private void calcularMonto() {
        if (participante.getEdad() < 18) {
            this.montoAbonar = categoria.getMontoMenores();
        } else {
            this.montoAbonar = categoria.getMontoMayores();
        }
    }

    public int getMontoAbonar() {
        return montoAbonar;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }
}