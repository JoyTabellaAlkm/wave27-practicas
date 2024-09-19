public class Inscripcion {
    public static int numInscripcion = 0;
    public Categoria categoria;
    public Participante participante;
    public int montoAbonar;

    public Inscripcion(Categoria categoria, Participante participante) {
        if(participante.edad < 18 && categoria.idCat == 3){
            System.out.println("No se puede inscribir un menor de 18 años a esta categoría");
            return;
        }
        numInscripcion++;
        this.categoria = categoria;
        this.participante = participante;
        definirMonto();
    }

    public void definirMonto(){
        switch (categoria.idCat){
            case 1:
                if (participante.edad < 18) {
                    montoAbonar = 1300;
                }
                else{
                    montoAbonar = 1500;
                }
                break;
            case 2:
                if (participante.edad < 18) {
                    montoAbonar = 2000;
                }
                else{
                    montoAbonar = 2300;
                }
                break;
            case 3:
                montoAbonar = 2800;
                break;
        }
    }
}