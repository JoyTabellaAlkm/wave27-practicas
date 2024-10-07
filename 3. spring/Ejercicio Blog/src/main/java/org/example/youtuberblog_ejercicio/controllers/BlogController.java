package org.example.youtuberblog_ejercicio.controllers;

import org.example.youtuberblog_ejercicio.dto.CreateBlogDTO;
import org.example.youtuberblog_ejercicio.entities.EntradaBlog;
import org.example.youtuberblog_ejercicio.exceptions.BlogAlreadyExists;
import org.example.youtuberblog_ejercicio.exceptions.BlogDoesntExist;
import org.example.youtuberblog_ejercicio.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @PostMapping("blog")
    //@ResponseStatus (value = HttpStatus.CREATED, reason = "Todo OK!")
    public EntradaBlog createBlog(@RequestBody CreateBlogDTO dto) throws BlogAlreadyExists {
        return blogService.createBlog(dto);
    }

    @GetMapping("blog/{id}")
    public EntradaBlog getEntradaBlog(@PathVariable Integer id) throws BlogDoesntExist {
        return blogService.getEntradaBlog(id);
    }

    @GetMapping("blog")
    public List<EntradaBlog> getAll()  {
        return blogService.getAll();
    }
}
