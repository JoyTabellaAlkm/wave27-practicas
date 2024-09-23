package co.mercadolibre.covid.repository;

import co.mercadolibre.covid.entity.Persona;
import co.mercadolibre.covid.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CovidRepository {

    private List<Sintoma> listaSintomas;
    private List<Persona> listaPersona;

    public CovidRepository() {

        this.listaSintomas = new ArrayList<>();
        this.listaPersona = new ArrayList<>();

        Sintoma tos = new Sintoma(1,"Tos","Bajo");
        Sintoma gusto = new Sintoma(2,"Perdida de gusto","Media");
        Sintoma respirar = new Sintoma(3,"Dificultad para respirar","Alta");

        listaSintomas.add(tos);
        listaSintomas.add(gusto);
        listaSintomas.add(respirar);

        listaPersona.add(new Persona(1,"Brayan","Diaz",25,tos));
        listaPersona.add(new Persona(2,"Juan","Perea",70,respirar));
        listaPersona.add(new Persona(3,"Nicolas","Cuervo",64,null));
        listaPersona.add(new Persona(4,"Brayan","Salazar",25,gusto));

    }

    public List<Sintoma> getListSymptom(){
        return listaSintomas;
    }

    public List<Persona> getListPersons() {
        return listaPersona;
    }
}
