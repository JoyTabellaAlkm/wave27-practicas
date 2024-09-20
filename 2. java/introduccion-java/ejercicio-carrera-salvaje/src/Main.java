public class Main {
    public static void main(String[] args) {
        CarreraDeLaSelva carrera = new CarreraDeLaSelva();
        carrera.crearCategorias();

        // Crear participantes
        Participante participante1 = new Participante(1, "12345678", "Juan", "Perez", 21, "1111111", "2222222", "O+");
        Participante participante2 = new Participante(2, "87654321", "Maria", "Lopez", 17, "3333333", "4444444", "A+");
        Participante participante3 = new Participante(3, "11223344", "Carlos", "Gomez", 25, "5555555", "6666666", "B+");

        // Inscribir participantes
        carrera.inscribirParticipante(participante2, 1);
        carrera.inscribirParticipante(participante3, 2);
        carrera.inscribirParticipante(participante3, 3);


        // Mostrar inscriptos en una categoría
        carrera.mostrarInscriptosPorCategoria(1);
        carrera.mostrarInscriptosPorCategoria(2);
        carrera.mostrarInscriptosPorCategoria(3);

        // Desinscribir un participante
        carrera.desinscribirParticipante(1);

        // Mostrar monto recaudado por categoría
        System.out.println("Monto recaudado categoría 1: $" + carrera.calcularMontoRecaudadoPorCategoria(1));
        System.out.println("Monto recaudado categoría 2: $" + carrera.calcularMontoRecaudadoPorCategoria(2));
        System.out.println("Monto recaudado categoría 3: $" + carrera.calcularMontoRecaudadoPorCategoria(3));

        // Mostrar monto total recaudado
        System.out.println("Monto total recaudado: $" + carrera.calcularMontoTotalRecaudado());
    }
}