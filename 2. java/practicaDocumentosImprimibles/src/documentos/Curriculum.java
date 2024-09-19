package documentos;

import interfaces.Imprimible;
import personas.Persona;

public class Curriculum implements Imprimible {
    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public Curriculum() {
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un curriculum");
    }
}
