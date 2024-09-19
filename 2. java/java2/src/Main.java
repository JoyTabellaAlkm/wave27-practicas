import java.util.*;
import java.util.List;

public class Main {

    static Map<String, Map<String, Object>> inscritos = new HashMap<>();

    static Map<String, Map<String, String>> categorias = new HashMap<>();
    static int contadorInscrito = 0;

    public static void main(String[] args) {
        categorias();
        Map<String, Object> persona1 =
                participante(1, "123", "jorge alberto", "rodriguez", 21, 32202, 20303,
                        "o+");
        Map<String, Object> persona2 =
                participante(2, "1223", "jorge alberto", "rodriguez", 35, 32202, 20303,
                        "o+");
        Map<String, Object> persona3 =
                participante(3, "122344", "ana", "rodriguez", 12, 32202, 20303,
                        "o+");
        inscribirAleatoriamente(persona1);
        inscribirAleatoriamente(persona2);
        inscribirAleatoriamente(persona3);
        System.out.println("los inscritos son de la categoria Circuto Medio:");
        mostarInscritos("Circuito_Medio");
        System.out.println("la lista despues del eliminado es:");
        removeInscripcion("1");
        System.out.println("el total de toda la carrera incluyendo todas las categorías es:");
        totalCategoria("Circuito_Corto");
        totalCategoria("Circuito_Medio");
        totalCategoria("Circuito_Avanzado");
        totalGeneral();


    }

    public static Map<String, Map<String, String>> categorias() {
        Map<String, String> circuitoCorto = new HashMap<>();
        Map<String, String> circuitoMedio = new HashMap<>();
        Map<String, String> circuitoAvanzado = new HashMap<>();
        circuitoCorto.put("id", "1");
        circuitoCorto.put("nombre", "Circuito chico");
        circuitoCorto.put("descripcion", "2 km por selva y arroyos.");
        circuitoCorto.put("precio_menores", "1300");
        circuitoCorto.put("precio_mayores", "1500");
        circuitoMedio.put("id", "2");
        circuitoMedio.put("nombre", "Circuito Medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro");
        circuitoMedio.put("precio_menores", "2000");
        circuitoMedio.put("precio_mayores", "2300");
        circuitoAvanzado.put("id", "3");
        circuitoAvanzado.put("nombre", "Circuito Avanzado");
        circuitoAvanzado.put("decripcion", "10 km por selva, arroyos, barro y escalada en piedra");
        circuitoAvanzado.put("precio_mayores", "2800");


        categorias.put("Circuito_Corto", circuitoCorto);
        categorias.put("Circuito_Medio", circuitoMedio);
        categorias.put("Circuito_Avanzado", circuitoAvanzado);

        return categorias;
    }

    private static Map<String, Object> participante(int numero, String dni, String nombre, String apellido,
                                                    int edad, int celular, int numeroEmergencia, String grupoSanguíneo) {
        Map<String, Object> participante = new HashMap<>();
        participante.put("numero_de_participante", numero);
        participante.put("dni", dni);
        participante.put("nombre", nombre);
        participante.put("apellido", apellido);
        participante.put("edad", edad);
        participante.put("celular", celular);
        participante.put("numeroEmergencia", numeroEmergencia);
        participante.put("grupoSanguineo", grupoSanguíneo);

        return participante;
    }

    private static String calcularMonto(String categoria, int edad) {
        Map<String, Map<String, String>> categorias = categorias();
        Map<String, String> categoriaElegida = categorias.get(categoria);
        if (edad < 18 && categoria.equals("Circuito_Avanzado")) {
            System.out.println("no se puede realizar inscripción a menores de edad");
            return "-1";
        }
        if (edad < 18) {
            return categoriaElegida.get("precio_menores");
        } else {
            return categoriaElegida.get("precio_mayores");
        }

    }

    private static void inscribir(int numeroInscripcion, String categoria, Map<String, Object> persona) {
        String monto = calcularMonto(categoria, (Integer) persona.get("edad"));
        if (!monto.equals("-1")) {
            Map<String, Object> participante = new HashMap<>();
            participante.put("numero_inscripcion", numeroInscripcion);
            participante.put("categoria", categoria);
            participante.put("persona", persona);
            participante.put("monto", monto);
            inscritos.put(String.valueOf(numeroInscripcion), participante);
        }
    }

    public static void inscribirAleatoriamente(Map<String, Object> participante) {
        Random random = new Random();
        List<String> categoriasList = new ArrayList<>(categorias.keySet());
        String categoria = categoriasList.get(random.nextInt(categoriasList.size()));
        inscribir(contadorInscrito++, categoria, participante);
    }

    private static void mostarInscritos(String categoria) {
        for (Map.Entry<String, Map<String, Object>> inscrip : inscritos.entrySet()) {
            if (inscrip.getValue().get("categoria").equals(categoria)) {
                System.out.println(inscrip);
            }

        }

    }

    private static void removeInscripcion(String numeroIncripcion) {
        if (inscritos.get(numeroIncripcion) != null) {
            String categoria = (String) inscritos.get(numeroIncripcion).get("categoria");
            inscritos.remove(numeroIncripcion);
            mostarInscritos(categoria);
        }
    }

    private static void totalCategoria(String categoria) {
        int total = 0;
        for (Map.Entry<String, Map<String, Object>> inscrip : inscritos.entrySet()) {

            if(inscrip.getValue().get("categoria").equals(categoria)){
                total = total + Integer.parseInt((String) inscrip.getValue().get("monto"));
            }

        }
        System.out.println("el total para la categoria "+categoria+ " es: " +total);
    }
    private static void totalGeneral(){
        int total = 0;
        for (Map.Entry<String, Map<String, Object>> inscrip : inscritos.entrySet()) {
            total = total + Integer.parseInt((String) inscrip.getValue().get("monto"));
        }
        System.out.println("el total general es: " + total);
    }

}