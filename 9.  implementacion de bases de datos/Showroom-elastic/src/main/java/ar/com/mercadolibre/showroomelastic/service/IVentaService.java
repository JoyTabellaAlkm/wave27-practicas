package ar.com.mercadolibre.showroomelastic.service;

import ar.com.mercadolibre.showroomelastic.dto.CreateOkDTO;
import ar.com.mercadolibre.showroomelastic.dto.PrendaDTO;
import ar.com.mercadolibre.showroomelastic.dto.VentaDTO;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    CreateOkDTO createVenta(VentaDTO ventaDTO);

    List<VentaDTO> getAllVentas();

    VentaDTO getVenta(Long codigo);

    CreateOkDTO updateVenta(Long codigo, VentaDTO VentaDTO);

    CreateOkDTO deleteVenta(Long codigo);

    List<VentaDTO> getAllVentasByDate(LocalDate date);

    List<PrendaDTO> getAllVentasByPrendas(Long number);
}
