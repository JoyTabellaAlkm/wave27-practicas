import java.util.*;

public class CarreraSelva {

     // Punto A - 3 Objetos del tipo de categoría
     Circuito circuitoChico = new Circuito(1, "Circuito Chico", "2 km por" +
             "selva y arroyos");
     Circuito circuitoMedio = new Circuito(2, "Circuito Medio", "5 km por" +
             "selva, arroyos y barro");
     Circuito circuitoAvanzado = new Circuito(3, "Circuito Avanzado", "10 km por" +
             "selva, arroyos, barro y escalada en piedra");


     // Punto B - Crear un Participante
     Participante participante = new Participante(1, 12345678,
             "Micaela", "Castañares", 28, 351527896,
             351437680, "A+");

     // Listas para almacenar las inscripciones por categoría
     private Map<Integer, Inscripcion> inscripcionesChico = new HashMap<>();
     private Map<Integer, Inscripcion> inscripcionesMedio = new HashMap<>();
     private Map<Integer, Inscripcion> inscripcionesAvanzado = new HashMap<>();

     // Inscribirlo en una categoria
     public void inscripcion () {
          int costoInsc = 0;
          int contadorInsc = 0;
          double totalChico = 0;
          double totalMedio = 0;
          double totalAvanzado = 0;

          while (true) {
               System.out.println("Inscripción - Menú de Opciones:");
               System.out.println("1, " + "Circuito Chico");
               System.out.println("2, " + "Circuito Medio");
               System.out.println("3, " + "Circuito Avanzado");
               System.out.println("4, Inscribir al azar");
               System.out.println("5, Mostrar inscriptos");
               System.out.println("6, Desinscribir");
               System.out.println("7, Mostrar monto recaudado");
               System.out.println("0, Salir");
               System.out.print("Presione el Número deseado: ");

               Scanner scanner = new Scanner(System.in);
               int numeroIngresado = scanner.nextInt();
               Random random = new Random();

               if (numeroIngresado == 0) {
                    break;
               }

               // Punto C - Inscripción al azar
               if (numeroIngresado == 4) {
                    numeroIngresado = random.nextInt(3) + 1;
                    System.out.println("La inscripción seleccionada es: ");
                    if (numeroIngresado == 1) {
                         System.out.println(circuitoChico);
                    } else if (numeroIngresado == 2) {
                         System.out.println(circuitoMedio);
                    } else {
                         System.out.println(circuitoAvanzado);
                    }
               }

               switch (numeroIngresado) {
                    case 1:
                         if (participante.edad < 18) {
                              contadorInsc++;
                              costoInsc = 1300;
                              Inscripcion inscripcion = new Inscripcion(costoInsc, participante);
                              inscripcionesChico.put(contadorInsc, inscripcion);
                         } else {
                              contadorInsc++;
                              costoInsc = 1500;
                              Inscripcion inscripcion = new Inscripcion(costoInsc, participante);
                              inscripcionesChico.put(contadorInsc, inscripcion);
                         }
                         break;
                    case 2:
                         if (participante.edad < 18) {
                              contadorInsc++;
                              costoInsc = 2000;
                              Inscripcion inscripcion = new Inscripcion(costoInsc, participante);
                              inscripcionesMedio.put(contadorInsc, inscripcion);
                         } else {
                              contadorInsc++;
                              costoInsc = 2300;
                              Inscripcion inscripcion = new Inscripcion(costoInsc, participante);
                              inscripcionesMedio.put(contadorInsc, inscripcion);
                         }
                         break;
                    case 3:
                         if (participante.edad < 18) {
                              System.out.println("No se permiten las inscripciones a menores de 18 años");
                         } else {
                              contadorInsc++;
                              costoInsc = 2800;
                              Inscripcion inscripcion = new Inscripcion(costoInsc, participante);
                              inscripcionesAvanzado.put(contadorInsc, inscripcion);
                         }
                         break;
                    case 5:
                         if (inscripcionesChico.isEmpty()) {
                              System.out.println("No hay inscripciones para el circuito chico");
                         } else {
                              System.out.println(inscripcionesChico);
                         }
                         if (inscripcionesMedio.isEmpty()) {
                              System.out.println("No hay inscripciones para el circuito medio");
                         } else {
                              System.out.println(inscripcionesMedio);
                         }
                         if (inscripcionesAvanzado.isEmpty()) {
                              System.out.println("No hay inscripciones para el circuito avanzado");
                         } else {
                              System.out.println(inscripcionesAvanzado);
                         }
                         break;
                    case 6:
                         System.out.print("Ingrese el ID del participante a desinscribir: ");
                         int participanteId = scanner.nextInt();
                         desinscribir(participanteId);
                         break;
                    case 7:
                         List<List<Inscripcion>> allInscriptions = Arrays.asList(inscripcionesChico, inscripcionesMedio, inscripcionesAvanzado);
                         if (allInscriptions.isEmpty()) {
                              System.out.println("No hay inscripciones para mostrar lo recaudado");
                         } else {
                              for (List<Inscripcion> inscripciones : allInscriptions) {
                                   int totalPorCategoria = 0;
                                   for (Inscripcion inscripcion : inscripciones) {
                                        // Sumar el costo de cada inscripción
                                        totalPorCategoria += inscripcion.getCostoInscripcion();
                                   }

                                   // Identificar la lista de inscripciones correspondiente y asignar el total
                                   if (inscripciones == inscripcionesChico) {
                                        totalChico = totalPorCategoria;
                                   } else if (inscripciones == inscripcionesMedio) {
                                        totalMedio = totalPorCategoria;
                                   } else if (inscripciones == inscripcionesAvanzado) {
                                        totalAvanzado = totalPorCategoria;
                                   }
                              }

                              // Imprimir los totales por categoría y el monto total general
                              System.out.println("Total recaudado por Circuito Chico: $" + totalChico);
                              System.out.println("Total recaudado por Circuito Medio: $" + totalMedio);
                              System.out.println("Total recaudado por Circuito Avanzado: $" + totalAvanzado);
                              double totalGeneral = totalChico + totalMedio + totalAvanzado;
                              System.out.println("Total general recaudado: $" + totalGeneral);
                         }
                         break;

                    default:
                         System.out.println("Opción no válida.");
                         break;

               }
          }
     }

     public void desinscribir(int participanteId) {
          List<List<Inscripcion>> allInscriptions = Arrays.asList(inscripcionesChico, inscripcionesMedio, inscripcionesAvanzado);

          for (List<Inscripcion> inscripciones : allInscriptions) {
               Inscripcion eliminar = null;
               for (Inscripcion inscripcion : inscripciones) {
                    if (inscripcion.getParticipante().numeroParticipante == participanteId) {
                         eliminar = inscripcion;
                         break;
                    }
               }
               if (eliminar != null) {
                    inscripciones.remove(eliminar);
                    System.out.println("Participante desinscripto: " + eliminar.getParticipante());
                    return;
               }
          }

          System.out.println("No se encontró un participante con el ID proporcionado.");
     }

     }


