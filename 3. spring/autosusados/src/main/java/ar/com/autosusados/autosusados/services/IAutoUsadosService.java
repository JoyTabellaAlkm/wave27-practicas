package ar.com.autosusados.autosusados.services;

import ar.com.autosusados.autosusados.dtos.AutoDTO;
import ar.com.autosusados.autosusados.entities.AutoUsados;

import java.util.Date;
import java.util.List;

public interface IAutoUsadosService {
    AutoDTO getAutoDTOId(Long id);
    List<AutoDTO> getAutoDTOBetweenPrices(Double since, Double to);
    List<AutoDTO> getAutosBetweenDates(Date since, Date to);
    List<AutoDTO> getAutos();
    boolean agregarAuto(AutoDTO auto);
}