import java.util.List;

public class Categoria {
    public int id;
    public String nombre;
    public String descripcion;
    private List<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = inscripciones;
    }

    public void inscribir(Inscripcion inscripcion) {
        for (int i = 0; i < inscripciones.size(); i++) {
            if (inscripciones.get(i).participante.numeroParticipante == inscripcion.participante.numeroParticipante) {
                System.out.println("El participante ya se encuentra inscripto en esta categoria.");
            } else {
                inscripciones.add(inscripcion);
            }
        }
    }
}