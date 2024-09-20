import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarreraDeLaSelva {
    private List<Categoria> categorias;
    private List<Inscripcion> inscripciones;

    public CarreraDeLaSelva() {
        this.categorias = new ArrayList<>();
        this.inscripciones = new ArrayList<>();
    }

    public void crearCategorias() {
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos", 1300, 1500));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro", 2000, 2300));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800));
    }

    public void inscribirParticipante(Participante participante, int categoriaId) {
        Categoria categoria = categorias.stream().filter(c -> c.getId() == categoriaId).findFirst().orElse(null);
        if (categoria == null || (categoriaId == 3 && participante.getEdad() < 18)) {
            System.out.println("No es posible inscribirse en esta categoría.");
            return;
        }
        int numeroInscripcion = inscripciones.size() + 1;
        Inscripcion inscripcion = new Inscripcion(numeroInscripcion, categoria, participante);
        inscripciones.add(inscripcion);
        System.out.println("Participante inscrito exitosamente.");
    }

    public void inscribirParticipantesAlAzar(List<Participante> participantes) {
        Random random = new Random();
        for (Participante participante : participantes) {
            int categoriaId = random.nextInt(3) + 1;
            inscribirParticipante(participante, categoriaId);
        }
    }

    public void mostrarInscriptosPorCategoria(int categoriaId) {
        Categoria categoria = categorias.stream().filter(c -> c.getId() == categoriaId).findFirst().orElse(null);
        if (categoria == null) {
            System.out.println("Categoría no encontrada.");
            return;
        }
        System.out.println("Participantes en la categoría " + categoria.getNombre() + ":");
        inscripciones.stream()
                .filter(i -> i.getCategoria().getId() == categoriaId)
                .forEach(System.out::println);
    }

    public void desinscribirParticipante(int numeroParticipante) {
        inscripciones.removeIf(i -> i.getParticipante().getNumero() == numeroParticipante);
        System.out.println("Participante desinscrito.");
    }

    public double calcularMontoRecaudadoPorCategoria(int categoriaId) {
        return inscripciones.stream()
                .filter(i -> i.getCategoria().getId() == categoriaId)
                .mapToDouble(Inscripcion::getMontoAbonar)
                .sum();
    }

    public double calcularMontoTotalRecaudado() {
        return inscripciones.stream()
                .mapToDouble(Inscripcion::getMontoAbonar)
                .sum();
    }

}
