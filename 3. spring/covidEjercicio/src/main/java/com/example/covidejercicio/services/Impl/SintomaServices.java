package com.example.covidejercicio.services.Impl;

import com.example.covidejercicio.dto.PersonaSintomaDto;
import com.example.covidejercicio.modelo.Persona;
import com.example.covidejercicio.modelo.Sintoma;
import com.example.covidejercicio.services.ISintomaServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaServices implements ISintomaServices {
    List<Sintoma> sintomaList = new ArrayList<>();
    List<Persona> personaList = new ArrayList<>();

    public SintomaServices() {
        sintomaList.add(new Sintoma("123","fiebre", "Alto"));
        sintomaList.add(new Sintoma("456","tos", "Moserado"));
        sintomaList.add(new Sintoma("789","Sarpullido", "leve"));

        personaList.add(new Persona(1, "jorge","roa",14,sintomaList));
        personaList.add(new Persona(1, "carlo","rodriguez",60,sintomaList));
        personaList.add(new Persona(1, "selena","gomez",70,sintomaList));
    }

    public List<Sintoma> obtenerSintomas() {
        return sintomaList;
    }

    public String obtenerNivelGravedadSiExiste(String nombre) {
        for(Sintoma sintoma : sintomaList){
            if(sintoma.getNombre().equals(nombre)){
                return  sintoma.getNivel_de_gravedad();
            }
        }
        return null;
    }

    @Override
    public List<PersonaSintomaDto> encontrarPersona() {
        return personaList.stream()
                .filter(persona -> persona.getEdad() >=60 && !persona.getSintomas().isEmpty())
                .map(persona -> new PersonaSintomaDto(persona.getNombre(), persona.getApellido()))
                .toList();
    }

}
