package co.mercadolibre.deportistas.service;

import co.mercadolibre.deportistas.dto.ConsultaDTO;
import co.mercadolibre.deportistas.entity.Deporte;

import java.util.List;

public interface IDeporteService {
    public List<Deporte> getDeporte();
    public Deporte getListaDeportesByName(String name);
    public List<ConsultaDTO> getListaDeportesDeportistas();

}