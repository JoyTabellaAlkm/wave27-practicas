public class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoAabonar;


    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoAabonar=" + montoAabonar +
                '}';
    }

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        calcularMonto();
    }

    public void calcularMonto(){
        int edadParticipante= participante.getEdad();
        int idCategoria = categoria.getId();
        switch (idCategoria){
            case 1:
                if(edadParticipante>=18) {
                    montoAabonar=1500;
                }
                else{
                    montoAabonar=1300;
                }
                break;
            case 2:
                if(edadParticipante>=18) {
                    montoAabonar=2300;
                }
                else{
                    montoAabonar=2000;
                }
                break;
            case 3:
                if(edadParticipante>=18) {
                    montoAabonar=2800;
                }
                else{
                    System.out.println("No se permiten menores de 18 años en la categoría");
                }
                break;
            default:
                System.out.println("Categoria inexistente");
        }
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMontoAabonar() {
        return montoAabonar;
    }

    public void setMontoAabonar(double montoAabonar) {
        this.montoAabonar = montoAabonar;
    }
}
