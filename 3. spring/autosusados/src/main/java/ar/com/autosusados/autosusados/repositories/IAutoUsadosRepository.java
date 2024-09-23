package ar.com.autosusados.autosusados.repositories;

import ar.com.autosusados.autosusados.entities.AutoUsados;

import java.util.Date;
import java.util.List;

public interface IAutoUsadosRepository {
    AutoUsados getAutoDTOId(Long id);
    List<AutoUsados> getAutoDTOBetweenPrices(Double since, Double to);
    List<AutoUsados> getAutosBetweenDates(Date since, Date to);
    List<AutoUsados> getAutos();
    boolean agregarAuto(AutoUsados auto);
}