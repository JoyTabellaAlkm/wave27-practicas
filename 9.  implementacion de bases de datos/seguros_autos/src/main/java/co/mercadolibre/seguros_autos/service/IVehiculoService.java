package co.mercadolibre.seguros_autos.service;

import co.mercadolibre.seguros_autos.dto.request.VehiculoRequestDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaDTO;
import co.mercadolibre.seguros_autos.dto.response.PatenteMarcaModeloDTO;
import co.mercadolibre.seguros_autos.dto.response.VehiculoResponseDTO;

import java.util.List;

public interface IVehiculoService {
    VehiculoResponseDTO crearVehiculo(VehiculoRequestDTO vehiculoRequestDTO);
    List<VehiculoResponseDTO> findAllVehiculo();

    PatenteDTO findAllPatente();
    List<PatenteMarcaDTO> findAllPatentesAndMarcaOrderByAnioFabricacion();
    PatenteDTO findPatentesByCantidadRuedasAndAnioFabricacionCurrentYear();
    List<PatenteMarcaModeloDTO> findVehiculosByPerdidaEconomicaAbove10000();
}
