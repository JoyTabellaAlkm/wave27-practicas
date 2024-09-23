package ar.com.mercadolibre.ejercicioDeportistas.service.Impl;

import ar.com.mercadolibre.ejercicioDeportistas.entitys.Deporte;
import ar.com.mercadolibre.ejercicioDeportistas.entitys.Persona;
import ar.com.mercadolibre.ejercicioDeportistas.entitys.dto.PersonaDto;
import ar.com.mercadolibre.ejercicioDeportistas.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeporteService implements IService {

    @Override
    public String getAllDeportes(List<Deporte> deportes){
        return deportes.toString();
    }

    @Override
    public String getDeporteName(List<Deporte> deportes, String name){
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(name))
                .map(Deporte::getNivel)
                .findFirst()
                .orElse("Deporte no encontrado");
    }

    @Override
    public String getPersonaDeportista(List<Persona> personas){
        return personas.stream()
                .map(PersonaDto::from)
                .map(PersonaDto::toString)
                .collect(Collectors.joining(", "));
    }
}
