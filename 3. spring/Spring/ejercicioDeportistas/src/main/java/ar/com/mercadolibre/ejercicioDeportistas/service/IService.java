package ar.com.mercadolibre.ejercicioDeportistas.service;

import ar.com.mercadolibre.ejercicioDeportistas.entitys.Deporte;
import ar.com.mercadolibre.ejercicioDeportistas.entitys.Persona;

import java.util.List;

public interface IService {

    String getAllDeportes(List<Deporte> deportes);
    String getDeporteName(List<Deporte> deportes, String name);
    String getPersonaDeportista(List<Persona> personas);
}
