package com.ejercicios.covid19.repository.Impl;

import com.ejercicios.covid19.dto.PersonaRiesgoDTO;
import com.ejercicios.covid19.model.Persona;
import com.ejercicios.covid19.model.Sintoma;
import com.ejercicios.covid19.repository.IPersonaRepository;
import com.ejercicios.covid19.repository.ISintomaRepository;
import com.ejercicios.covid19.service.Impl.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
   private List<Persona> listaPersonas = new ArrayList<>();
    private List<PersonaRiesgoDTO> listaPersonasRiesgo = new ArrayList<>();
   private ISintomaRepository sintomaRepository = new SintomaRepositoryImpl();
   private PersonaRiesgoDTO personaRiesgoDTO = new PersonaRiesgoDTO();

    public PersonaRepositoryImpl() {
        List<Sintoma> listaSintomas1 = new ArrayList<>();
        listaSintomas1.add(sintomaRepository.verSintomas().get(0));
        listaSintomas1.add(sintomaRepository.verSintomas().get(2));
        List<Sintoma> listaSintomas2 = new ArrayList<>();
        listaSintomas2.add(sintomaRepository.verSintomas().get(0));
        listaSintomas2.add(sintomaRepository.verSintomas().get(1));
    listaPersonas.add(new Persona(1L,"Luis","Rodriguez", 67, listaSintomas1));
    listaPersonas.add(new Persona(2L,"Pedro","Perez", 40, listaSintomas2));
        for (Persona persoMayor : listaPersonas) {
            if (persoMayor.getEdad() >= 60){
                for (Sintoma sintoma : persoMayor.getListaSintomas()){
                    if(sintoma.getNivelDeGravedad().equals("Alto")){
                        personaRiesgoDTO.setNombreCompletoPersona(persoMayor.getNombre() + " " + persoMayor.getApellido());
                        personaRiesgoDTO.setEdad(persoMayor.getEdad());
                        personaRiesgoDTO.setSintomaDeRiesgo(true);
                        listaPersonasRiesgo.add(personaRiesgoDTO);
                        break;
                    }
                }
            }
        }

    }



    @Override
    public List<Persona> verPersonas() {
return listaPersonas;
    }

    public List<PersonaRiesgoDTO> verPersonasConRiesgo() {
        return listaPersonasRiesgo;
    }
}
