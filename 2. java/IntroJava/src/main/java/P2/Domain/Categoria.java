package P2.Domain;

import java.util.List;

public class Categoria {

    private int id;
    private String nombre;
    private int kilometros;
    private List<String> obstaculos;
    private int montoAPagarMenores;
    private int montoAPagarMayores;

    public Categoria(int id, String nombre, int kilometros, List<String> obstaculos, int montoAPagarMenores, int montoAPagarMayores) {
        this.id = id;
        this.nombre = nombre;
        this.kilometros = kilometros;
        this.obstaculos = obstaculos;
        this.montoAPagarMenores = montoAPagarMenores;
        this.montoAPagarMayores = montoAPagarMayores;
    }

    public int getMontoAPagar(int edad){
        if(edad < 18){
            return montoAPagarMenores;
        }else{
            return montoAPagarMayores;
        }
    }

    public int getMontoAPagarMayores(){
        return montoAPagarMayores;
    }

    public void setMontoAPagarMenores(int montoAPagar){
        this.montoAPagarMenores = montoAPagar;
    }

    public void setMontoAPagarMayores(int montoAPagar){
        this.montoAPagarMayores = montoAPagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(short kilometros) {
        this.kilometros = kilometros;
    }

    public List<String> getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(List<String> obstaculos) {
        this.obstaculos = obstaculos;
    }
}
