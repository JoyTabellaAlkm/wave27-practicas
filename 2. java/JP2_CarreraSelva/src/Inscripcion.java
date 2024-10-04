public class Inscripcion {
    private int numeroInscripcion;
    private Integer valorInscripcion;
    private Categoria categoria;
    private Participante participante;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
    }

    public Integer getValorInscripcion() {
        if (participante.getEdad() < 18) {
            this.valorInscripcion = categoria.getValorInscripcionMenores();
        } else {
            this.valorInscripcion = categoria.getValorInscripcionMayores();
        }
        return this.valorInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Participante getParticipante() {
        return participante;
    }
}
