package Imprimibles;
import java.util.List;

public class Curriculum implements iImprimible {
    private String nombrePersona;
    private List<String> habilidades;

    public Curriculum() {
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un curriculum");
    }
}
