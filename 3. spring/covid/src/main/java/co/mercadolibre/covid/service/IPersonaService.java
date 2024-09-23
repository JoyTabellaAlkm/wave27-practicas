package co.mercadolibre.covid.service;

import co.mercadolibre.covid.dto.CovidDTO;
import co.mercadolibre.covid.entity.Persona;

import java.util.List;

public interface IPersonaService {
    public List<CovidDTO> getRiskPerson();
}
