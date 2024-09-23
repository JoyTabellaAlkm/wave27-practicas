package com.ejercicios.Blog.service.impl;

import com.ejercicios.Blog.dto.BlogDTO;
import com.ejercicios.Blog.entity.Blog;
import com.ejercicios.Blog.exception.BlogIdException;
import com.ejercicios.Blog.exception.BlogNotFoundException;
import com.ejercicios.Blog.repository.BlogRepository;
import com.ejercicios.Blog.service.IBlogService;
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
    public String createBlog(BlogDTO blog) {
        if(repository.findById(blog.getId()) != null){
            throw new BlogIdException("Ya existe un blog con id: " + blog.getId());
        }
        Blog blogCreated = repository.save(dtoToEntity(blog));
        return "Creado exitosamente con id: " + blogCreated.getId();
    }
    @Override
    public List<BlogDTO> findAll() {
        List<Blog> blogs = repository.findAll();
        List<BlogDTO> dtos = blogs.stream().map(blog -> entityToDto(blog)).toList();
        return dtos;
    }
    @Override
    public BlogDTO findById(int id) {
        if(repository.findById(id) == null){
            throw new BlogNotFoundException("El blog con id: " + id + " no existe");
        }
        return entityToDto(repository.findById(id));
    }
    private Blog dtoToEntity(BlogDTO dto){
        Blog blog = new Blog(dto.getId(), dto.getTitulo(), dto.getAutor(), dto.getFechaPublicacion());
        return blog;
    }
    private BlogDTO entityToDto(Blog entity){
        BlogDTO blog = new BlogDTO(entity.getId(), entity.getTitulo(), entity.getAutor(), entity.getFechaPublicacion());
        return blog;
    }
}
