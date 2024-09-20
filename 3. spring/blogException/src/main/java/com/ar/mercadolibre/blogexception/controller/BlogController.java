package com.ar.mercadolibre.blogexception.controller;

import com.ar.mercadolibre.blogexception.dto.BlogDTO;
import com.ar.mercadolibre.blogexception.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blogDTO) {
         return ResponseEntity.status(HttpStatus.CREATED).body(blogService.createBlog(blogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> findBlogById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.findBlogById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(blogService.findAll());
    }

}
