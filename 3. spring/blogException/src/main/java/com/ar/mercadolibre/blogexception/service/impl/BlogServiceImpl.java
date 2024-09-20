package com.ar.mercadolibre.blogexception.service.impl;

import com.ar.mercadolibre.blogexception.dto.BlogDTO;
import com.ar.mercadolibre.blogexception.exception.BlogAlreadyExistException;
import com.ar.mercadolibre.blogexception.exception.BlogNotFoundException;
import com.ar.mercadolibre.blogexception.repository.BlogRepository;
import com.ar.mercadolibre.blogexception.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public BlogDTO findBlogById(int id) {

            BlogDTO blogDTO = repository.findBlogById(id);
            if (blogDTO == null) {
                throw new BlogNotFoundException("No hay ningun blog con el id " + id);
            }

        return blogDTO;
    }

    @Autowired
    BlogRepository repository;

    @Override
    public String createBlog(BlogDTO blogDTO) {
        boolean idExist = repository.findAll().containsKey(blogDTO.getId());

            if (idExist) {
                throw new BlogAlreadyExistException("El blog con el id" + blogDTO.getId() + " ya existe.");
            }

        return "Blog creado con éxito con el id " + blogDTO.getId();
    }

    public List<BlogDTO> findAll() {
        Map<Integer, BlogDTO> blogs = repository.findAll();
        return blogs.values().stream().toList();
    }
}
