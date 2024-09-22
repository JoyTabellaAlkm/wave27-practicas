public class Main {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.");
        Categoria categoria2 = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoria3 = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        Participante participante1 = new Participante(123, 234, "Juan", "Perez", 25, 987654321, 123456789, "A+");
        Participante participante2 = new Participante(124, 235, "Maria", "Gomez", 18, 987654322, 123456788, "B-");
        Participante participante3 = new Participante(125, 236, "Pedro", "Gonzalez", 16, 987654323, 123456787, "AB+");


        Inscripcion inscripcion1 = new Inscripcion(1, categoria1, participante1);
        Inscripcion inscripcion2 = new Inscripcion(2, categoria2, participante2);
        Inscripcion inscripcion3 = new Inscripcion(3, categoria3, participante3);


    }
}