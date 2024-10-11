import java.util.ArrayList;
import java.util.List;

class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    protected List<Participante> participantes;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.participantes = new ArrayList<>();
    }

    public Categoria() {
    }

    @Override
    public String toString() {
        return "id: " + id + "\nNombre: " + nombre + "\nDescripcion: " + descripcion + "\nParticipantes: \n" + participantes.toString();
    }

    public int getId() {
        return id;
    }
}