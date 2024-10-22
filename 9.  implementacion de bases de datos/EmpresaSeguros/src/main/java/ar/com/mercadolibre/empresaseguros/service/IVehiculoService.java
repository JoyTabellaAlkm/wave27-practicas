package ar.com.mercadolibre.empresaseguros.service;

import ar.com.mercadolibre.empresaseguros.dto.*;
import ar.com.mercadolibre.empresaseguros.entity.Siniestro;
import ar.com.mercadolibre.empresaseguros.entity.Vehiculo;

import java.util.List;

public interface IVehiculoService {

    List<Vehiculo> getAllVehiculos();

    CreateOkDTO createVehiculo(Vehiculo vehiculo);

    CreateOkDTO createSiniestro(Siniestro siniestro);

    List<PatenteDTO> getVehiculoByPatente();

    List<PatenteAndMarcaOrderDTO> getVehiculoByPatenteAndMarcaOrderByAnioFabricacion();

    List<PatenteDTO> getVehiculoByPatenteAndCantidadRuedasAfterFour();

    List<VehiculoDTO> getVehiculoBySiniestros();

    List<VehiculoSiniestroDTO> getVehiculoBySiniestrosAndPerdida();
}
