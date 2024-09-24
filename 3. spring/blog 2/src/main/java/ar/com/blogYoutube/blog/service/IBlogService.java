package ar.com.blogYoutube.blog.service;

import ar.com.blogYoutube.blog.dto.EntradaBlogResponseDTO;

import java.util.List;

public interface IBlogService {
    String agregarBlog(EntradaBlogResponseDTO entradaBlog);

    EntradaBlogResponseDTO obtenerEntradaBlogporId(String id);

    List<EntradaBlogResponseDTO> obtenerEntradaBlogs();
}
