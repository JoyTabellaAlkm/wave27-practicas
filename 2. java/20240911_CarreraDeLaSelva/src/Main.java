import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    List<Inscripcion> inscripciones= new ArrayList<>();

    //a
    Categoria circuitoChico = new Categoria( 1, DescripcionCategoria.CIRCUITOCHICO.getNombre(), DescripcionCategoria.CIRCUITOCHICO.getDescripcion());
    Categoria circuitoMedio = new Categoria( 2, DescripcionCategoria.CIRCUITOMEDIO.getNombre(), DescripcionCategoria.CIRCUITOMEDIO.getDescripcion());
    Categoria circuitoAvanzado = new Categoria( 3, DescripcionCategoria.CIRCUITOAVANZADO.getNombre(), DescripcionCategoria.CIRCUITOAVANZADO.getDescripcion());

    //b
    Participante participante1 = new Participante(1, 12345678, "Juan", "Pérez", 25, "O+", 1122334455L, 1122334456L);
    Inscripcion inscripcion1= new Inscripcion(10,circuitoChico,participante1);
    inscripciones.add(inscripcion1);

    System.out.println("Monto a abonar por " + participante1.getNombre() + " : "  + inscripcion1.getMontoAabonar());

    //c
    Participante participante2 = new Participante(2, 23456789, "María", "García", 30, "A-", 2233445566L, 2233445567L);
    Participante participante3 = new Participante(3, 34567890, "Pedro", "López", 35, "B+", 3344556677L,  3344556678L);
    Participante participante4 = new Participante(4, 45678901, "Lucía", "Martínez", 28, "AB+", 4455667788L, 4455667789L);
    Participante participante5 = new Participante(5, 56789012, "Carlos", "Fernández", 40, "O-", 5566778899L,  5566778900L);
    Participante participante6 = new Participante(6, 67890123, "Sofía", "Gómez", 22, "A+", 6677889900L, 6677889901L);

    Inscripcion inscripcion2= new Inscripcion(20,circuitoMedio,participante2);
    Inscripcion inscripcion3= new Inscripcion(30,circuitoAvanzado,participante3);
    Inscripcion inscripcion4= new Inscripcion(40,circuitoMedio,participante4);
    Inscripcion inscripcion5= new Inscripcion(50,circuitoMedio,participante5);
    Inscripcion inscripcion6= new Inscripcion(60,circuitoAvanzado,participante6);

    inscripciones.add(inscripcion2);
    inscripciones.add(inscripcion3);
    inscripciones.add(inscripcion4);
    inscripciones.add(inscripcion5);
    inscripciones.add(inscripcion6);

    //d
    System.out.println("Imprimir categoria Avanzado");
    inscripciones.stream().filter(i->i.getCategoria().getNombre().equalsIgnoreCase("CIRCUITO MEDIO")).forEach(System.out::println);

    //e
    System.out.println("Desinscribir Participante4");
    Inscripcion p= inscripciones.stream().filter(i->i.getParticipante().equals(participante4)).findFirst().orElse(null);
    inscripciones.remove(p);
    System.out.println("Imprimir categoria Avanzado");
    inscripciones.stream().filter(i->i.getCategoria().getNombre().equalsIgnoreCase("CIRCUITO MEDIO")).forEach(System.out::println);

    //f
    System.out.println("Calcular el monto total recaudado por cada categoría y");
    Double monto = inscripciones.stream()
            .filter(c -> c.getCategoria().getNombre().equalsIgnoreCase("Circuito Chico"))
            .map(v -> v.getMontoAabonar())
            .reduce(0.0, Double::sum);
    System.out.println("Categoria Circuito Chico: " + monto);

    Double monto2 = inscripciones.stream()
            .filter(c -> c.getCategoria().getNombre().equalsIgnoreCase("Circuito Medio"))
            .map(v -> v.getMontoAabonar())
            .reduce(0.0, Double::sum);
    System.out.println("Categoria Circuito Medio: " + monto2);

    Double monto3 = inscripciones.stream()
            .filter(c -> c.getCategoria().getNombre().equalsIgnoreCase("Circuito Avanzado"))
            .map(v -> v.getMontoAabonar())
            .reduce(0.0, Double::sum);
    System.out.println("Categoria Circuito Avanzado: " + monto);

    Double total= monto +monto2 + monto3;
    System.out.println("Total recaudado: " + total);


    }
}
