package domain;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    protected Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = categoria.calcularMonto(participante.getEdad());
    }


    protected void cancelar() {
        categoria.quitarInscripcion(this);
    }

    protected int getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Número de inscripción: " + numero + "\n" + participante.toString();
    }
}
