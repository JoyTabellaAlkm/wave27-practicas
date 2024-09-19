import domain.Categoria;
import domain.Participante;

public class Main {
    public static void main(String[] args) {
        Categoria circuitoChico = new Categoria(1, Categoria.NOMBRE_CIRCUITO_CHICO, "2km por selva y arroyos.");
        Categoria circuitoMedio = new Categoria(2, Categoria.NOMBRE_CIRCUITO_MEDIO, "5km por selva, arroyos y barro.");
        Categoria circuitoAvanzado = new Categoria(3, Categoria.NOMBRE_CIRCUITO_AVANZADO, "10km por selva, arroyos, barro y escalada en piedra");

        Participante participante1 = new Participante(1, "11.111.111", "Alejandro", "Magno", 21, "144231231", "", "A+");
        Participante participante2 = new Participante(2, "12.111.111", "Esteban", "Lee", 17, "144233331", "", "B-");
        Participante participante3 = new Participante(3, "12.111.123", "Charly", "Cimino", 18, "155233331", "", "B+");

        participante1.inscribir(1, circuitoChico);
        participante2.inscribir(2, circuitoMedio);
        participante3.inscribir(3, circuitoAvanzado);

        circuitoChico.listarInscriptos();

        participante1.desinscribir();
        circuitoChico.listarInscriptos();
    }
}