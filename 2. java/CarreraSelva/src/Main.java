import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    static List<Participante> participantes = new ArrayList<>();
    static List<Inscripcion> inscripciones = new ArrayList<>();
    static List<Categoria> categorias = new ArrayList<>();
    public static void main(String[] args) {
        Main m = new Main();
        //AÑADIENDO PARTICIPANTES
        participantes.add(new Participante(participantes.size() + 1,3231, "Pepito", "Pérez", 21, "3213454432", "3125437655", "A+"));
        participantes.add(new Participante(participantes.size() + 1, 3231, "Jane", "Doe", 16, "3333245430", "3105895887", "A+"));
        participantes.add(new Participante(participantes.size() + 1, 3231, "Marc", "Hill", 34 , "3018439910", "3025849913", "O-"));

        //AÑADIENDO CATEGORIAS
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro."));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));
        m.menuPrincipal();
    }

    public void menuPrincipal(){
        System.out.println("=============================================================");
        System.out.println("CARRERA DE LA SELVA");
        System.out.println("1. Añadir nuevo participante \n2. Inscribir participante a una categoría.  \n3. Desinscribir participante. \n4. Mostrar participantes por categoría.  \n5. Ver monto total recaudado por categoría.  \n6. Ver monto total recaudado de toda la carrera.\n7. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = input.nextInt();
        input.nextLine();
        switch (opcion){
            case 1: anadirParticipante();
                break;
            case 2: inscribirParticipante();
                break;
            case 3: desinscribirParticipante();
                break;
            case 4: participantesPorCategoria();
                break;
            case 5: montoPorCategoria();
                break;
            case 6: montoTotal();
                break;
            case 7:
                break;
            default:
                System.out.println("Opcion inválida");
                this.menuPrincipal();
                break;
        }

    }
    public void anadirParticipante(){
        System.out.println("=============================================================");
        System.out.println("AÑADIR NUEVO PARTICIPANTE");
        System.out.println("Ingrese el DNI");
        int dni = input.nextInt();
        input.nextLine();
        System.out.print("Ingrese el nombre");
        String nombre = input.nextLine();
        System.out.print("Ingrese el apellido");
        String apellido = input.nextLine();
        System.out.print("Ingrese la edad");
        int edad = input.nextInt();
        input.nextLine();
        System.out.print("Ingrese el celular");
        String celular = input.nextLine();
        System.out.print("Ingrese un número de emergencia");
        String numeroEmergencia = input.nextLine();
        System.out.print("Ingrese el grupo sanguíneo");
        String sangre = input.nextLine();
        participantes.add(new Participante(participantes.size() + 1, dni, nombre, apellido, edad, celular, numeroEmergencia, sangre));
        System.out.println("Participante añadido exitosamente. Presione enter para volver al menú principal");
        input.nextLine();
        menuPrincipal();
    }
    public void inscribirParticipante(){
        System.out.println("=============================================================");
        System.out.println("INSCRIBIR PARTICIPANTE A UNA CATEGORÍA");
        System.out.print("Ingrese el número del participante al que quieres inscribir: ");
        int participanteId = input.nextInt();
        for (Inscripcion inscripcion : inscripciones){
            if(inscripcion.participante.numeroParticipante == participanteId){
                System.out.println("El participante ya está inscrito.");
                menuPrincipal();
            }
        }
        input.nextLine();
        System.out.println("CATEGORÍAS");
        for (Categoria categoria : categorias){
            System.out.println(categoria.toString());
        }
        System.out.print("Seleccione el id de la categoría a la cual quiere inscribir al participante: ");
        int categoriaId =  input.nextInt();
        inscripciones.add(new Inscripcion(categorias.get(categoriaId-1), participantes.get(participanteId-1)));
        categorias.get(categoriaId-1).anadirMonto(inscripciones.getLast().montoAbonar);
        System.out.println("Participante inscrito exitosamente. Presione enter para volver al menú principal");
        input.nextLine();
        input.nextLine();
        menuPrincipal();
    }
    public void desinscribirParticipante(){
        System.out.print("Ingrese el número del participante al que quieres desinscribir: ");
        int participanteId = input.nextInt();
        input.nextLine();
        inscripciones.removeIf(inscripcion -> inscripcion.participante.numeroParticipante == participanteId);
        System.out.println("Participante desinscrito. Presione enter para volver al menú principal");
        input.nextLine();
        menuPrincipal();
    }
    public void participantesPorCategoria(){
        System.out.println("=============================================================");
        System.out.println("PARTICIPANTES POR CATEGORIA");
        for (Categoria categoria : categorias){
            System.out.println(categoria.nombre);
           for(Inscripcion inscripcion : inscripciones){
               if(inscripcion.categoria == categoria){
                   System.out.println(inscripcion.participante.toString());
               }
           }
        }
        System.out.println("Presione enter para volver al menú principal");
        input.nextLine();
        menuPrincipal();
    }
    public void montoPorCategoria(){
        System.out.println("=============================================================");
        System.out.println("MONTO POR CATEGORÍA");
        for (Categoria categoria : categorias){
            System.out.println(categoria.nombre);
            System.out.println("Monto recaudado: $" + categoria.montoRecaudado);
        }
        System.out.println("Presione enter para volver al menú principal");
        input.nextLine();
        menuPrincipal();
    }
    public void montoTotal(){
        System.out.println("=============================================================");
        System.out.println("MONTO TOTAL RECAUDADO");
        double montoTotal = 0;
        for (Categoria categoria : categorias){
            montoTotal = montoTotal +categoria.montoRecaudado;
        }
        System.out.println("$" + montoTotal);
        System.out.println("Presione enter para volver al menú principal");
        input.nextLine();
        menuPrincipal();
    }
}

