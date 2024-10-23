package co.mercadolibre.seguros_autos.service;

import co.mercadolibre.seguros_autos.dto.request.SiniestroRequestDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaModeloDTO;
import co.mercadolibre.seguros_autos.dto.response.PerdidasTotalesDTO;
import co.mercadolibre.seguros_autos.dto.response.SiniestroResponseDTO;

import java.util.List;

public interface ISiniestroService {

    SiniestroResponseDTO createSiniestro(SiniestroRequestDTO siniestroRequestDTO);
    List<SiniestroResponseDTO> findAllSiniestro();
    List<PatenteMarcaModeloDTO> getVehiculosByPerdidaEconomicaAbove10000();
    List<PerdidasTotalesDTO> getVehiculosByPerdidaEconomicaAbove10000Agrupada();
}
