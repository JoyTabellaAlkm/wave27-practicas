package impresora;

import java.util.List;

public class Curriculum implements IImprimir {

    private List<String> listaAtributos;
    private List<String> listaHabilidades;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo CVs...");
    }
}
