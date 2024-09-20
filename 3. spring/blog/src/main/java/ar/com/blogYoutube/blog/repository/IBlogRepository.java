package ar.com.blogYoutube.blog.repository;

import ar.com.blogYoutube.blog.dto.EntradaBlogResponseDTO;

import java.util.List;

public interface IBlogRepository {
    public boolean guardarEntrada(EntradaBlogResponseDTO entrada);

    public EntradaBlogResponseDTO buscarEntrada(String id);

    public List<EntradaBlogResponseDTO> buscarEntradas();

}
