package ar.com.mercadolibre.ejercicioYoutuber.repository;

import ar.com.mercadolibre.ejercicioYoutuber.dto.BlogDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class YoutuberRepository implements IRepository{

    private static List<BlogDTO> entradaBlogList = new ArrayList<>();

    @Override
    public Boolean addEntradaBlog(BlogDTO entradaBlog) {
       return entradaBlogList.add(entradaBlog);
    }

    @Override
    public BlogDTO findById(int id){
        return entradaBlogList.stream().filter(blogDTO -> blogDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<BlogDTO> getAllBlog(){
        return entradaBlogList;
    }

    @Override
    public Boolean isNull(){
        return entradaBlogList.isEmpty();
    }
}
