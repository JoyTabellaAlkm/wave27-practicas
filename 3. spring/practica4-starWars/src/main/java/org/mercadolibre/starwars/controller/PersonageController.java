package org.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.starwars.dto.PersonageDTO;
import org.mercadolibre.starwars.entity.Personage;
import org.mercadolibre.starwars.service.IPersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class PersonageController {
    @Autowired
    IPersonageService iPersonageService;

    @GetMapping
    public List<PersonageDTO> getPersonage() {
        try {
            return iPersonageService.getPersonage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{name}")
    public List<PersonageDTO> getPersonageByName(@PathVariable String name) {
        try {
            return iPersonageService.getPersonageByName(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
