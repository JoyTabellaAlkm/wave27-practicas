package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clases.Categoria;
import clases.Participante;
import clases.Inscripcion;

public class Logica {

    private static int idInscripciones = 1;
    private static List<Inscripcion> inscripciones = new ArrayList<>();

    private static Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos.",1300, 1500);
    private static Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro.", 2000, 2300);
    private static Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.",0,2800);

    private static List<Categoria> categorias = Arrays.asList(circuitoChico, circuitoMedio, circuitoAvanzado);

    public static void inscribirParticipante(Participante participante, String nombreCategoria) {

        Categoria categoria = categorias.stream().filter(
                categoriaFilter -> categoriaFilter.getNombre().equals(nombreCategoria)).findFirst().orElse(null);

        assert categoria != null;
        if(categoria.getMontoMenores() == 0){
            if(participante.getEdad() < 18){
                throw new RuntimeException("La categoria no admite menores");
            }
        }

        Inscripcion inscripcionf = inscripciones.stream().filter(
                inscripcionFilter -> inscripcionFilter.getParticipante().getId()==participante.getId() &&
                        inscripcionFilter.getCategoria().getId()==categoria.getId()
                    ).findFirst().orElse(null);

        if (inscripcionf != null){

            System.out.println(participante.getNombre()+" ya esta inscrito en "+categoria.getNombre()+"\n");

        }else{

            Inscripcion inscripcion = new Inscripcion(idInscripciones, participante, categoria);
            idInscripciones++;
            inscripciones.add(inscripcion);

            System.out.println("El participante " + participante.getNombre() + " ha sido inscrito a " + categoria.getNombre() + " y debe pagar " + inscripcion.montoPagar() + "\n");
        }
    }

    public static void inscribirParticipanteAleatorio(Participante participante) {

        Random random = new Random();
        int numeroCategoriaRandom = random.nextInt(categorias.size())+1;

        Categoria categoria = categorias.stream().filter(
                categoriaFilter -> categoriaFilter.getId() == (numeroCategoriaRandom)).findFirst().orElse(null);

        inscribirParticipante(participante, categoria.getNombre());

    }

    public static void mostrarInscripciones(String nombreCategoria) {

        Categoria categoria = categorias.stream().filter(
                categoriaFilter -> categoriaFilter.getNombre().equals(nombreCategoria)).findFirst().orElse(null);

        System.out.println("Lista de inscripciones para la categoria "+categoria.getNombre());
        for (Inscripcion inscripcion: inscripciones){

            if (inscripcion.getCategoria().getId() == categoria.getId()){
                System.out.println("  -Inscripcion No."+inscripcion.getId()+", categoria: "+inscripcion.getCategoria().getNombre());
            }

        }
        System.out.println("\n");

    }

    public static void desincribirParticipante(int idParticipante, String nombreCategoria) {

        inscripciones.removeIf(inscripcion ->
                inscripcion.getParticipante().getId()==(idParticipante) &&
                        inscripcion.getCategoria().getNombre().equals(nombreCategoria)
        );

        mostrarInscripciones(nombreCategoria);

    }

    public static void montoTotalRecaudado() {

        System.out.println("Monto recaudado por categoria:");
        int montoTotal = 0;
        for (Categoria categoria : categorias) {
            int montoTotalCategoria = 0;
            for (Inscripcion inscripcion : inscripciones) {
                if (inscripcion.getCategoria().getId() == categoria.getId()) {
                    montoTotalCategoria = montoTotalCategoria + inscripcion.montoPagar();
                }
            }
            System.out.println("  -El monto recaudado por la categoria "+categoria.getNombre()+" es de $"+montoTotalCategoria);
            montoTotal = montoTotal + montoTotalCategoria;
        }
        System.out.println("El monto total recaudado es de $"+montoTotal);
    }
}
