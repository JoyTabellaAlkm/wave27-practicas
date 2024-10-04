import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Gestor {
    private Map<Integer,Categoria> categorias;
    private Map<Integer,Participante> participantes;
    private  Map<Categoria,List<Inscripcion>> listadoXCategoria;//Creacion de map que permite clasificar las inscripciones por categoria
    private Map<Participante, Inscripcion> listadoParticipantes;//Creacion de map que permitira almacenar los participantes con sus inscripciones vrificando que no se permita inscribir de nuevo

    public Gestor() {
        categorias = new HashMap<>();
        participantes = new HashMap<>();
        listadoXCategoria = new HashMap<>();
        listadoParticipantes = new HashMap<>();
        crearCategorias();
    }

    private void crearCategorias(){
        //Definicion de categorias (se definen de acuerdo al ejercicio pero se podria modificar el codigo para crear categorias nuevas
        Categoria circuitoChico = new Categoria(1,"Circuito chico", "2 km por selva y arroyos.",1500, 1300);
        Categoria circuitoMedio = new Categoria(2,"Circuito medio", "5 km por selva, arroyos y barro.",2300,2000);
        Categoria circuitoAvanzado = new Categoria(3,"Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.",2800, null);
        categorias.put(1,circuitoChico);
        categorias.put(2, circuitoMedio);
        categorias.put(3, circuitoAvanzado);
    }

    public void anadirParticipante(int numeroParticipante, String nombre, String apellido, int dni, int edad, int celular, int numeroEmergencia, String grupoSanguineo){
        participantes.put(numeroParticipante,new Participante(numeroParticipante, nombre, apellido, dni, edad, celular, numeroEmergencia, grupoSanguineo));
    }


    public void anadirInscripcion(int idParticipante, int idCategoria, int idInscripcion) {
        Participante participante = participantes.get(idParticipante);
        Categoria categoria = categorias.get(idCategoria);
        if (listadoParticipantes.containsKey(participante)) { //comprobar que el participante no se encuentre inscrito en otra categoria
            System.out.println("El participante número: " + participante.getNumeroParticipante() + ", ya se encuentra inscrito en la categoria " + listadoParticipantes.get(participante).getCategoria().getNombre());
        } else {
            //Realizar inscripcion
            Inscripcion inscripcion = new Inscripcion(idInscripcion, categoria, participante);
            if(inscripcion.getValorInscripcion()!=null){ //verificar que el particpante pueda inscribirse en esa categoria
                //Añadir al listado de inscripciones para posteriores verificaciones
                listadoParticipantes.put(participante, inscripcion);
                //Añadir al listado por categoria
                List<Inscripcion> listado = listadoXCategoria.get(inscripcion.getCategoria());
                if (listado != null) {
                    // Añadir la nueva inscripcion a la lista existente
                    listado.add(inscripcion);
                } else {
                    // Si no existe la lista, crear una nueva y añadir al mapa
                    List<Inscripcion> nuevaLista = new ArrayList<>();
                    nuevaLista.add(inscripcion);
                    listadoXCategoria.put(categoria, nuevaLista);
                }
                System.out.println("Inscripción exitosa");
            }else{
                System.out.println("El participante número " + participante.getNumeroParticipante() + " no se puede inscribir a la categoria: " + categoria.getNombre());
            }
        }
    }
    public void desincribirParticipante(int idParticipante){
        Participante participante = participantes.get(idParticipante);
        Inscripcion inscripcion = listadoParticipantes.get(participante);//encontrar inscripcion
        if(inscripcion==null){
            System.out.println("El participante no esta inscrito a ninguna categoria");
        }else{
            listadoParticipantes.remove(participante); //eliminar del listado de partidipantes
            List<Inscripcion> listado = listadoXCategoria.get(inscripcion.getCategoria());//Traer las inscripciones de la categoria
            listado.remove(inscripcion); //eliminar las inscripciones
            System.out.println("Participante desinscrito con exito ");
            mostrarXCategoria(inscripcion.getCategoria().getId());
        }
    }

    //Metodo que permite el calculo del monto
    public Integer recaudoXCategoria(Categoria categoria){
        Integer recaudo = 0;
        List<Inscripcion>inscripcionesXCategoria = listadoXCategoria.get(categoria);
        for (Inscripcion inscripcion: inscripcionesXCategoria){
            recaudo += inscripcion.getValorInscripcion();
        }
        return recaudo;
    }
    public Integer recaudoTotal(){
        Integer recaudo = 0;
        for (Map.Entry<Categoria, List<Inscripcion>> listado : listadoXCategoria.entrySet()) {
            List<Inscripcion> inscripciones = listado.getValue();
            for (Inscripcion inscripcion: inscripciones){
                recaudo += inscripcion.getValorInscripcion();
            }
        }
        return recaudo;
    }

    //Mostrar resultados

    public void mostrarCategorias(){
        for (Map.Entry<Integer, Categoria> listado : categorias.entrySet()) {
            System.out.println(listado.getKey()+". "+listado.getValue().getNombre());
        }
    }

    public void mostrarParticipantes(){
        if (participantes.isEmpty()){
            System.out.println("No hay participantes registrados");
        }else {
            for (Map.Entry<Integer, Participante> listado : participantes.entrySet()) {
                System.out.println(listado.getKey()+". "+listado.getValue().getNombre()+" "+listado.getValue().getApellido());
            }
        }

    }

    public void mostrarTodasInscripciones() {
        System.out.println("Se registraron las sigientes inscripciones");
        for (Map.Entry<Categoria, List<Inscripcion>> listado : listadoXCategoria.entrySet()) {
            System.out.println("---------------------------------------------------------------------------");
            List<Inscripcion> inscripciones = listado.getValue();
            System.out.println("Inscripciones para la categoria: "+listado.getKey().getNombre());
            System.out.println("---------------------------------------------------------------------------");
            for (Inscripcion inscripcion: inscripciones){
                System.out.println("La inspripcion número " + inscripcion.getNumeroInscripcion() + ", fue registrada con la siguiente información:");
                System.out.println("Participante: " + inscripcion.getParticipante().getNombre() + " " + inscripcion.getParticipante().getApellido());
                System.out.println("Monto a pagar: "+inscripcion.getValorInscripcion());
                System.out.println("----------------------------------------------------------------------------");
            }
            System.out.println("Total de recaudo de la categoria: " + recaudoXCategoria(listado.getKey()));
        }
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Total de recaudo en la carrera: " + recaudoTotal());
    }
    public void  mostrarXCategoria(int idCategoria){
        Categoria categoria = categorias.get(idCategoria);
        List<Inscripcion>inscripcionesXCategoria = listadoXCategoria.get(categoria);
        if(inscripcionesXCategoria==null){
            System.out.println("La categoria: " + categoria.getNombre()+", no tiene tiene inscripciones");
        }else{
            System.out.println("La categoria: " + categoria.getNombre()+", tiene las siguientes inscripciones:");
            System.out.println("---------------------------------------------------------------------------");
            for (Inscripcion inscripcion: inscripcionesXCategoria){
                System.out.println("Número de inscripción: " + inscripcion.getNumeroInscripcion());
                System.out.println("Participante: " + inscripcion.getParticipante().getNombre() + " " + inscripcion.getParticipante().getApellido());
                System.out.println("Monto a pagar: "+inscripcion.getValorInscripcion());
                System.out.println("---------------------------------------------------------------------------");
            }
            System.out.println("Total de recaudo de la categoria: " + recaudoXCategoria(categoria));
        }
    }
    //Metodos para mostrar unicamente el recaudo
    public void mostrarRecaudoTotal(){
        System.out.println("El recaudo total fue: "+recaudoTotal());
    }
    public void mostrarRecaudoXCategoria(Categoria categoria){
        System.out.println("El recaudo total de la categoaria fue: "+recaudoXCategoria(categoria));
    }

}
