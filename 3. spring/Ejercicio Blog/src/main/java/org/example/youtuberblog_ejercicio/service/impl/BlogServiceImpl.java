package org.example.youtuberblog_ejercicio.service.impl;

import org.example.youtuberblog_ejercicio.dto.CreateBlogDTO;
import org.example.youtuberblog_ejercicio.entities.EntradaBlog;
import org.example.youtuberblog_ejercicio.exceptions.BlogAlreadyExists;
import org.example.youtuberblog_ejercicio.exceptions.BlogDoesntExist;
import org.example.youtuberblog_ejercicio.repository.IBlogRepository;
import org.example.youtuberblog_ejercicio.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    public EntradaBlog createBlog(CreateBlogDTO dto) throws BlogAlreadyExists {
        return this.blogRepository.createBlog(dto);
    }

    public EntradaBlog getEntradaBlog(Integer id) throws BlogDoesntExist {
        return blogRepository.getEntradaBlog(id);
    }

    public List<EntradaBlog> getAll() {
        return blogRepository.getAll();
    }
}
