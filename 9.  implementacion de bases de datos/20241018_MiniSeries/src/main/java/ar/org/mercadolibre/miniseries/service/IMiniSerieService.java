package ar.org.mercadolibre.miniseries.service;

import ar.org.mercadolibre.miniseries.model.MiniSerie;

import java.util.List;

public interface IMiniSerieService {

    List<MiniSerie> getAllMiniSeries();

    MiniSerie getMiniSerieById(Long id);
}
