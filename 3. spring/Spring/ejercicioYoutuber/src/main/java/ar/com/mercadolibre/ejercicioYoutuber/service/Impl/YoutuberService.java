package ar.com.mercadolibre.ejercicioYoutuber.service.Impl;

import ar.com.mercadolibre.ejercicioYoutuber.dto.BlogDTO;
import ar.com.mercadolibre.ejercicioYoutuber.entity.EntradaBlog;
import ar.com.mercadolibre.ejercicioYoutuber.exception.FoundException;
import ar.com.mercadolibre.ejercicioYoutuber.exception.NullException;
import ar.com.mercadolibre.ejercicioYoutuber.repository.YoutuberRepository;
import ar.com.mercadolibre.ejercicioYoutuber.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YoutuberService implements IService {

    private final YoutuberRepository youtuberRepository;

    @Autowired
    public YoutuberService(YoutuberRepository youtuberRepository){
        this.youtuberRepository = youtuberRepository;
    }

    @Override
    public String createEntradaBlog(BlogDTO entradaBlog) {
        BlogDTO blogDTO1 = youtuberRepository.findById(entradaBlog.getId());

        if(blogDTO1 != null && !youtuberRepository.isNull() ){
            throw new FoundException("El id del blog ingresado: " + entradaBlog.getId() + ", ya existe." + "Por lo tanto," +
                    "no es posible su creación.");
        }
        BlogDTO blogDTO = new BlogDTO(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor());
        youtuberRepository.addEntradaBlog(blogDTO);
        return "El blog con id: " + entradaBlog.getId() + ", ha sido creado con exito.";
    }

    @Override
    public BlogDTO findById(int id){
        BlogDTO objeto = youtuberRepository.findById(id);
        if (objeto == null){throw new NullException(("El blog con el id: " + id + ", no ha sido encontrado."));}
        return objeto;
    }

    @Override
    public List<BlogDTO> getAll(){
        return youtuberRepository.getAllBlog();
    }



}
