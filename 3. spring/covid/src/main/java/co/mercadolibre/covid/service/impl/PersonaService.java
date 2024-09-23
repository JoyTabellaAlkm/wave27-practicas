package co.mercadolibre.covid.service.impl;

import co.mercadolibre.covid.dto.CovidDTO;
import co.mercadolibre.covid.entity.Persona;
import co.mercadolibre.covid.repository.CovidRepository;
import co.mercadolibre.covid.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    CovidRepository covidRepository;

    @Override
    public List<CovidDTO> getRiskPerson() {
        return covidRepository.getListPersons().stream()
                .filter(p -> p.getEdad()>=60 && p.getSintoma() != null)
                .map(p -> new CovidDTO(p.getNombre(),p.getApellido(),p.getEdad(),p.getSintoma()))
                .toList();
    }
}
