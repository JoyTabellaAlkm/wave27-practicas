package ar.com.mercadolibre.ejercicioYoutuber.service;

import ar.com.mercadolibre.ejercicioYoutuber.dto.BlogDTO;
import ar.com.mercadolibre.ejercicioYoutuber.entity.EntradaBlog;

import java.util.List;

public interface IService {
    String createEntradaBlog(BlogDTO entradaBlog);
    BlogDTO findById(int id);
    List<BlogDTO> getAll();
}
