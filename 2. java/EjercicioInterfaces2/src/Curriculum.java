import java.util.List;

public class Curriculum implements IImprimir{
    public String nombre;
    public String dni;
    public List<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println("Imprimiento curriculum");
    }
}
