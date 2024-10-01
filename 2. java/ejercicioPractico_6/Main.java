import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Circuito> circuitos = new ArrayList<>();
        circuitos.add(new Circuito("Circuito chico", 0, "2KM por selva y arroyos"));
        circuitos.add(new Circuito("Circuito medio", 1, "5KM por selva, arroyos y barro"));
        circuitos.add(new Circuito("Circuito Avanzado", 2, "10KM por selva, arroyos, barro y escalada en piedra"));

        List<Participante> participantes = new ArrayList<>();
        participantes.add(new Participante("38414099", "Stephanie", "Castillo", 17, "1133556677", "42224224", "A+", 0));
        participantes.add(new Participante("38484099", "Camila", "Torres", 17, "1133556677", "42224224", "AB+", 1));
        participantes.add(new Participante("38891145", "Fernando", "Sanchez", 18, "112344433", "49431161", "A-", 0));
        participantes.add(new Participante("38833145", "Ignacio", "Vazques", 18, "112344433", "49431161", "O-", 1));
        participantes.add(new Participante("39891145", "Celeste", "Gomez", 20, "112344433", "49431161", "O+", 2));

        int recaudacionCircuitoChico = participantes.stream()
                .filter(p -> p.getCircuitoElegido() == 0)
                .mapToInt(p -> {
                    int importeAPagar = calcularImporte(p); // Implementa la lógica para calcular el importe
                    System.out.println(detalleParticipante(p, circuitos));
                    return importeAPagar;
                })
                .sum();

        int recaudacionCircuitoMedio = participantes.stream()
                .filter(p -> p.getCircuitoElegido() == 1)
                .mapToInt(p -> {
                    int importeAPagar = calcularImporte(p);
                    System.out.println(detalleParticipante(p, circuitos));
                    return importeAPagar;
                })
                .sum();

        int recaudacionCircuitoAvanzado = participantes.stream()
                .filter(p -> p.getCircuitoElegido() == 2)
                .mapToInt(p -> {
                    int importeAPagar = calcularImporte(p);
                    System.out.println(detalleParticipante(p, circuitos));
                    return importeAPagar;
                })
                .sum();

        int recaudacionTotal = recaudacionCircuitoChico + recaudacionCircuitoMedio + recaudacionCircuitoAvanzado;

        System.out.println("Recaudación del circuito chico: " + recaudacionCircuitoChico);
        System.out.println("Recaudación del circuito medio: " + recaudacionCircuitoMedio);
        System.out.println("Recaudación del circuito avanzado: " + recaudacionCircuitoAvanzado);
        System.out.println("Recaudación total: " + recaudacionTotal);
    }

    private static String detalleParticipante(Participante participante, List<Circuito> circuitos) {
        int circuitoElegido = participante.getCircuitoElegido();
        return String.format("El participante: %s\nCon edad: %d\nSe inscribirá en la categoría: %s\nDescripción: %s\n",
                participante.getNombre(), participante.getEdad(),
                circuitos.get(circuitoElegido).getNombre(),
                circuitos.get(circuitoElegido).getDescripcion());
    }

    private static int calcularImporte(Participante participante) {
        return p.getImporteDelCircuito();
    }
}
