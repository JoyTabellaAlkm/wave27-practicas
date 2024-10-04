package Clases;

import Interfaces.IImprimible;

import java.util.List;

public class Curriculum extends Persona implements IImprimible {

    private List<String> habilidades;

    public Curriculum(String name, List<String> habilidades) {
        super(name);
        this.habilidades = habilidades;
    }

    @Override
    public String imprimir() {
        return  "Curriculum: {" +super.toString()+
                " y habilidades=" + habilidades +
                "} " ;
    }
}
