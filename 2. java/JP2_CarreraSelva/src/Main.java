import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Mostrar categorias");
            System.out.println("2. Crear participante");
            System.out.println("3. Mostrar participantes");
            System.out.println("4. Inscribir participantes");
            System.out.println("5. Mostrar todas las inscripciones");
            System.out.println("6. Mostrar inscripciones por categoria");
            System.out.println("7. Desincribir participante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");


            opcion = scanner.nextInt();
            int idCategoria,idInscripcion,idParticipante;

            switch (opcion) {
                case 1:
                    gestor.mostrarCategorias();
                    break;
                case 2:
                    System.out.println("Ingrese el número del participante:");
                    int numero = scanner.nextInt();
                    System.out.println("Ingrese el nombre del participante:");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido del participante:");
                    String apellido = scanner.next();
                    System.out.println("Ingrese el dni del participante:");
                    int dni = scanner.nextInt();
                    System.out.println("Ingrese la edad del participante:");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el  celular del participante:");
                    int celular = scanner.nextInt();
                    System.out.println("Ingrese el número de emergencia del participante:");
                    int numeroEmergencia = scanner.nextInt();
                    System.out.println("Ingrese el grupo sanguineo del participante:");
                    String grupoSanguineo = scanner.next();
                    gestor.anadirParticipante(numero,nombre,apellido,dni,edad,celular,numeroEmergencia,grupoSanguineo);
                    break;
                case 3:
                    gestor.mostrarParticipantes();
                    break;
                case 4:
                    System.out.println("Elija un participante (si no hay participantes digite 0):");
                    gestor.mostrarParticipantes();
                    idParticipante = scanner.nextInt();
                    if(idParticipante!=0){
                        System.out.println("Elija una categoria:");
                        gestor.mostrarCategorias();
                        idCategoria= scanner.nextInt();
                        System.out.println("Digite el id de la inscripción:");
                        idInscripcion= scanner.nextInt();
                        gestor.anadirInscripcion(idParticipante,idCategoria, idInscripcion);
                    }
                    break;
                case 5:
                    gestor.mostrarTodasInscripciones();
                    break;
                case 6:
                    System.out.println("Elija una categoria:");
                    gestor.mostrarCategorias();
                    idCategoria= scanner.nextInt();
                    gestor.mostrarXCategoria(idCategoria);
                    break;
                case 7:
                    System.out.println("Elija un participante (si no hay participantes digite 0):");
                    gestor.mostrarParticipantes();
                    idParticipante= scanner.nextInt();
                    gestor.desincribirParticipante(idParticipante);
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor seleccione una opción del menú.");
                    break;
            }
            System.out.println();
        } while (opcion != 0);

        scanner.close();


    }
}
