package ej2;

import java.util.List;

public class Curriculums implements Impresion{

    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private List<String> habilidades;

    public Curriculums(String nombre, String apellido, int dni, int telefono, List<String> habilidades){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    public String contenido(){
        System.out.println("Curriculum impreso");
        return "Nombre: " + " " +
                this.nombre + ". " +
                "Apellido: " + " " +
                this.apellido + ". " +
                "Dni: " + " " +
                this.dni + ". " +
                "Telefono: " + " " +
                this.telefono + " " +
                "Habilidades: " + " " +
                this.habilidades;

    }
}
