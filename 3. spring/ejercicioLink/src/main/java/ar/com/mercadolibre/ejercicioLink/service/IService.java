package ar.com.mercadolibre.ejercicioLink.service;

import ar.com.mercadolibre.ejercicioLink.dto.CreateLinkDTO;
import ar.com.mercadolibre.ejercicioLink.dto.EstadisticaDTO;
import ar.com.mercadolibre.ejercicioLink.dto.LinkId;
import ar.com.mercadolibre.ejercicioLink.entitys.Link;

public interface IService {

    EstadisticaDTO obtenerEstadistica(Integer id);

    LinkId crearLink(CreateLinkDTO createLinkDTO);

    String getUrl(Integer id);

    String invalidLink(Integer id);


}
