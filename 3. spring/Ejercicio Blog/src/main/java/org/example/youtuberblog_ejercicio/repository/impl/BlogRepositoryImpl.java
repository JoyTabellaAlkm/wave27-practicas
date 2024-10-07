package org.example.youtuberblog_ejercicio.repository.impl;

import org.example.youtuberblog_ejercicio.dto.CreateBlogDTO;
import org.example.youtuberblog_ejercicio.entities.EntradaBlog;
import org.example.youtuberblog_ejercicio.exceptions.BlogAlreadyExists;
import org.example.youtuberblog_ejercicio.exceptions.BlogDoesntExist;
import org.example.youtuberblog_ejercicio.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private HashMap<Integer, EntradaBlog> entradas;

    public BlogRepositoryImpl() {
        this.entradas = new HashMap<>();
    }

    public EntradaBlog createBlog(CreateBlogDTO dto) throws BlogAlreadyExists {
        if(this.entradas.get(dto.getId()) != null) {
            throw new BlogAlreadyExists();
        }
        EntradaBlog entrada = new EntradaBlog(
            dto.getId(),
            dto.getTitulo(),
            dto.getAutor(),
            dto.getFechaPublicacion()
        );
        entradas.put(entrada.getId(), entrada);
        return entrada;
    }

    public EntradaBlog getEntradaBlog(Integer id) throws BlogDoesntExist {
        if(entradas.get(id) == null) {
            throw new BlogDoesntExist();
        }
        return entradas.get(id);
    }

    public List<EntradaBlog> getAll() {
        return new ArrayList<>(entradas.values());
    }
}
