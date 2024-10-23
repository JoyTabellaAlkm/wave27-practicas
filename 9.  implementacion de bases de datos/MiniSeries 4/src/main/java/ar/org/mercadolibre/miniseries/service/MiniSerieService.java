package ar.org.mercadolibre.miniseries.service;

import ar.org.mercadolibre.miniseries.model.MiniSerie;
import ar.org.mercadolibre.miniseries.repository.MiniSerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiniSerieService implements IMiniSerieService {
    @Autowired
    MiniSerieRepository miniSerieRepository;


    public List<MiniSerie> getAllMiniSeries() {
        return miniSerieRepository.findAll();
    }

    public MiniSerie getMiniSerieById(Long id) {
        return miniSerieRepository.findById(id).orElse(null);
    }

    /*
    public MiniSerie saveMiniSerie(MiniSerie miniSerie) {
        return miniSerieRepository.save(miniSerie);
    }

    public void deleteMiniSerie(Long id) {
        miniSerieRepository.deleteById(id);
    }*/

}
