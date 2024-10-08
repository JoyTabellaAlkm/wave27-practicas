public class Inscripcion {
    public int numero;
    public Categoria categoria;
    public Participante participante;
    public double montoAbono;

    public void calcularMonto(Categoria categoria, Participante participante ) {
        switch (categoria.id) {
            case 1:
                if(participante.edad < 18) {
                    montoAbono = 1300;
                } else {
                    montoAbono = 1500;
                }
                break;
            case 2:
                if(participante.edad < 18) {
                    montoAbono = 2000;
                } else {
                    montoAbono = 2300;
                }
                break;
            case 3:
                if (participante.edad < 18) {
                    System.out.println("No se permiten menores de edad en esta categoria.");
                } else {
                    montoAbono = 2800;
                }
                break;
            default:
                montoAbono = 0;
                break;
        }
    }

    public Inscripcion() {

    }

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        calcularMonto(categoria, participante);
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoAbono=" + montoAbono +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Inscripcion i = (Inscripcion) obj;

        return this.participante.dni == i.participante.dni;
    }
}
