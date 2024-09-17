package P2.Domain;

public class Inscripcion {
    private int numeroInscripcion;
    private Participante participante;
    private Categoria categoria;

    private boolean pagada;

    public Inscripcion(int numeroInscripcion, Participante participante, Categoria categoria) {
        this.numeroInscripcion = numeroInscripcion;
        this.participante = participante;
        this.categoria = categoria;
        this.pagada = false;
    }

    public int montoAPagar(){
        return categoria.getMontoAPagar(participante.getEdad());
    }

    public void pagar(){
        pagada = true;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
