package P2.Domain;

import java.util.List;

public class CircuitoAvanzado extends Categoria{
    public CircuitoAvanzado(int id, String nombre, int kilometros, List<String> obstaculos, int montoAPagarMenores, int montoAPagarMayores) {
        super(id, nombre, kilometros, obstaculos, montoAPagarMenores, montoAPagarMayores);
    }

    @Override
    public int getMontoAPagar(int edad) {
        if(edad < 18){
            throw new RuntimeException("No se puede inscribir a un menor en esta categoria");
        }else{
            return super.getMontoAPagarMayores();
        }
    }
}
