package ar.com.blogYoutube.blog.service.impl;

import ar.com.blogYoutube.blog.dto.EntradaBlogResponseDTO;
import ar.com.blogYoutube.blog.dto.ExceptionDTO;
import ar.com.blogYoutube.blog.exception.BuscarPorIdException;
import ar.com.blogYoutube.blog.exception.CrearEntradaBlogException;
import ar.com.blogYoutube.blog.exception.IdRegistradaEnEntradaBlogException;
import ar.com.blogYoutube.blog.repository.imp.BlogRepository;
import ar.com.blogYoutube.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public String agregarBlog(EntradaBlogResponseDTO entradaBlog) {
        EntradaBlogResponseDTO seEncuentraIdRegitrado = obtenerEntradaBlogporId(entradaBlog.getId());
        if (seEncuentraIdRegitrado == null) {
            throw new IdRegistradaEnEntradaBlogException("El Id: " + entradaBlog.getId() + "se encuentra registrao.");
        }
        String mensaje = "Se agrego correctamente el ID: " + entradaBlog.getId();
        if(!blogRepository.guardarEntrada(entradaBlog)) {
            throw new CrearEntradaBlogException("No se pudo agregar el blog con id: " + entradaBlog.getId());
        }
        return mensaje;
    }

    @Override
    public EntradaBlogResponseDTO obtenerEntradaBlogporId(String id) {
        EntradaBlogResponseDTO entradaBuscada = blogRepository.buscarEntrada(id);

        if(entradaBuscada == null) {
            throw new BuscarPorIdException("No se pudo encontrar la entrada del blog con id: " + id);
        }
        return entradaBuscada;
    }

    @Override
    public List<EntradaBlogResponseDTO> obtenerEntradaBlogs() {
        return blogRepository.buscarEntradas();
    }
}
