package org.mercadolibre.starwars.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.starwars.dto.PersonageDTO;
import org.mercadolibre.starwars.entity.Personage;
import org.mercadolibre.starwars.service.IPersonageService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonageService implements IPersonageService {

    @Override
    public List<PersonageDTO> getPersonage() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("data/personages.json");
        List<Personage> personages = objectMapper.readValue(resource.getFile(), new TypeReference<List<Personage>>() {});
        return personageToPersonageDTO(personages);
    }

    @Override
    public List<PersonageDTO> getPersonageByName(String name) throws IOException {
        return this.getPersonage().stream().filter(personageDTO -> {
            return personageDTO.getName().toLowerCase().contains(name.toLowerCase());
        }).toList();
    }

    private List<PersonageDTO> personageToPersonageDTO(List<Personage> inEntity){
        List<PersonageDTO> dtoList = new ArrayList<>();
        inEntity.forEach(personage -> {
            PersonageDTO dtoPerson = new PersonageDTO(
                    personage.getName(),
                    personage.getHeight(),
                    personage.getMass(),
                    personage.getGender(),
                    personage.getHomeworld(),
                    personage.getSpecies()
            );
            dtoList.add(dtoPerson);
        });
        return dtoList;
    }
}
