package org.bootcamp;

public class Curriculum implements Imprimible {
    // incluye a una persona con todos sus atributos más una lista de sus habilidades.

    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        String atributos = "\n - " + String.join("\n - ", persona.getAtributos());
        String habilidades = "\n - " + String.join("\n - ", persona.getHabilidades());

        System.out.printf("""
                Nombre completo: %s
                Atributos: %s
                Habilidades: %s
                """,
                persona.getNombreCompleto(),
                atributos,
                habilidades);
    }
}
