package ar.com.mercadolibre.ejercicioYoutuber.repository;

import ar.com.mercadolibre.ejercicioYoutuber.dto.BlogDTO;
import java.util.List;

public interface IRepository {
    Boolean addEntradaBlog(BlogDTO entradaBlog);
    BlogDTO findById(int id);
    List<BlogDTO> getAllBlog();
    Boolean isNull();
}
