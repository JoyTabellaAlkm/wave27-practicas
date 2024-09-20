package ar.org.mercadolibre.ejercicioblog.service.impl;

import ar.org.mercadolibre.ejercicioblog.dto.BlogDto;
import ar.org.mercadolibre.ejercicioblog.entity.Blog;
import ar.org.mercadolibre.ejercicioblog.exception.BlogIdException;
import ar.org.mercadolibre.ejercicioblog.exception.BlogNotFoundException;
import ar.org.mercadolibre.ejercicioblog.repository.BlogRepository;
import ar.org.mercadolibre.ejercicioblog.service.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogRepository repository;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String createBlog(BlogDto blog) {
        if(repository.findById(blog.getId()) != null){
            throw new BlogIdException("Ya existe un blog con id: " + blog.getId());
        }
        Blog blogCreated = repository.save(dtoToEntity(blog));
        return "Creado exitosamente con id: " + blogCreated.getId();
    }
    @Override
    public List<BlogDto> findAll() {
        List<Blog> blogs = repository.findAll();
        List<BlogDto> dtos = blogs.stream().map(blog -> entityToDto(blog)).toList();
        return dtos;
    }
    @Override
    public BlogDto findById(int id) {
        if(repository.findById(id) == null){
            throw new BlogNotFoundException("El blog con id: " + id + " no existe");
        }
        return entityToDto(repository.findById(id));
    }
    private Blog dtoToEntity(BlogDto dto){
        Blog blog = new Blog(dto.getId(), dto.getTitulo(), dto.getAutor(), dto.getFechaPublicacion());
        return blog;
    }
    private BlogDto entityToDto(Blog entity){
        BlogDto blog = new BlogDto(entity.getId(), entity.getTitulo(), entity.getAutor(), entity.getFechaPublicacion());
        return blog;
    }
}
