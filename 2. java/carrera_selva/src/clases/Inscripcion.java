package clases;

public class Inscripcion {
    private int id;
    private Participante participante;
    private Categoria categoria;

    public Inscripcion(int id, Participante participante, Categoria categoria) {
        this.id = id;
        this.participante = participante;
        this.categoria = categoria;
    }

    public int montoPagar(){
        if (participante.getEdad() < 18){
            return categoria.getMontoMenores();
        }else{
            return categoria.getMontoMayores();
        }
    }

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

}
