package Ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Se plantea desarrollar un programa que permita mediante una interfaz imprimir diferentes tipos de documentos.
//
//Entre los tipos de documentos se encuentran:
//
//
//Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
//Libros en PDF: Incluyen atributos como cantidad de páginas, nombre del autor, título y género.
//Informes: Incluyen un texto de n longitud, cantidad de páginas, autor, y revisor.
//Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método estático de
// una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso el contenido.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Carlos", "Apellido", 20);
        List<String> habi = new ArrayList<>();
        habi.add("Programacion");

        Curriculum curriculum = new Curriculum(persona, habi);

        String[] texto = {"Hola"};
        Informe informe = new Informe(texto,2,"Carlos", "Leidy");


        IImprimir.imprimir(curriculum);
        IImprimir.imprimir(informe);

    }
}
