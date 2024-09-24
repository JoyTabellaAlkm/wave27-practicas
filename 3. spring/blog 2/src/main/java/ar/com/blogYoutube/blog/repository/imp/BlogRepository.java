package ar.com.blogYoutube.blog.repository.imp;

import ar.com.blogYoutube.blog.dto.EntradaBlogResponseDTO;
import ar.com.blogYoutube.blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<EntradaBlogResponseDTO> entradas;

    public BlogRepository() {
        entradas = new ArrayList<EntradaBlogResponseDTO>();
    }

    public boolean guardarEntrada(EntradaBlogResponseDTO entrada) {
        return entradas.add(entrada);
    }

    public EntradaBlogResponseDTO buscarEntrada(String id) {
        return entradas.stream().filter( entrada -> entrada.getId().equals(id)).findFirst().orElse(null);
    }

    public List<EntradaBlogResponseDTO> buscarEntradas() {
        return entradas;
    }
}
