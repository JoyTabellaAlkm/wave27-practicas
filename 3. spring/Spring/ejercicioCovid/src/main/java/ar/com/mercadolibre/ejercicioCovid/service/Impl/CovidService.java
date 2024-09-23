package ar.com.mercadolibre.ejercicioCovid.service.Impl;

import ar.com.mercadolibre.ejercicioCovid.entitys.Sintoma;
import ar.com.mercadolibre.ejercicioCovid.entitys.dto.PersonaDto;
import ar.com.mercadolibre.ejercicioCovid.repository.SintomaRepository;
import ar.com.mercadolibre.ejercicioCovid.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService implements IService {

    SintomaRepository iRepository;

    @Autowired
    public CovidService(SintomaRepository iRepository){
        this.iRepository = iRepository;
    }

    @Override
    public List<Sintoma> findBySymptom(){
        return iRepository.getAllSymptoms();
    }

    @Override
    public String findSimptomByName(String name){
        List<Sintoma> sintomas = iRepository.getAllSymptoms();
        return sintomas.stream()
                .filter(sintoma -> sintoma.getNombre().equalsIgnoreCase(name))
                .map(Sintoma::getNivel_de_gravedad)
                .findFirst()
                .orElse("Sintoma no encontrado");
    }

    @Override
    public String findRiskPerson(){
        List<PersonaDto> personaDtoList = iRepository.getAllPersonas();
        return personaDtoList.stream()
                .filter(personaDto -> personaDto.getEdad() >= 60)
                .map(PersonaDto::toString)
                .collect(Collectors.joining(", "));
    }
}
