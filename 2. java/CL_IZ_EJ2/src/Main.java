import Clases.Curriculum;
import Clases.Informe;
import Clases.Libro;
import Clases.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Curriculum
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Programacion");
        habilidades.add("danza");
        Curriculum curriculum = new Curriculum("Mari",habilidades);
        //Libro
        Libro libro = new Libro(200,"Ana","Principito","Fantasia");
        //Informe
        Informe informe = new Informe("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sed rhoncus sapien. Nullam vestibulum risus erat, vitae faucibus diam blandit eget. Nullam et tortor dolor. Nulla at sodales nibh. Duis eros dui, laoreet ac molestie quis, rhoncus facilisis mi. Etiam condimentum risus vitae porttitor iaculis. Sed at mauris magna. Sed massa nulla, venenatis in iaculis at, volutpat et tellus.","Mari","Ana",3);
        //Imprimir los objetos
        System.out.println(curriculum.imprimir());
        System.out.println(libro.imprimir());
        System.out.println(informe.imprimir());
    }
}