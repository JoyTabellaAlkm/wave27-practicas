package org.mercadolibre.starwars.service;

import org.mercadolibre.starwars.dto.PersonageDTO;

import java.io.IOException;
import java.util.List;

public interface IPersonageService {
    List<PersonageDTO> getPersonage() throws IOException;
    List<PersonageDTO> getPersonageByName(String name) throws IOException;
}
