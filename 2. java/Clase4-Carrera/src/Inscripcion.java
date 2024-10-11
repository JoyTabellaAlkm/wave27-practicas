
class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int montoAbonar;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        if (participante.getEdad()<18){
            if (categoria.getId()==1){
                montoAbonar=1300;
            } else if (categoria.getId()==2) {
                montoAbonar=2000;
            }
        } else {
            if (categoria.getId()==1){
                montoAbonar=1500;
            } else if (categoria.getId()==2) {
                montoAbonar=2300;
            } else if (categoria.getId()==3) {
                montoAbonar=2800;
            }
        }
        System.out.println("El monto a abonar es "+ montoAbonar);

        this.categoria.participantes.add(participante);
    }

    public Inscripcion() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getMontoAbonar() {
        return montoAbonar;
    }
}