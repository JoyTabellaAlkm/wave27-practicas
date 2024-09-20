package com.ejercicios.Blog.controller;

import com.ejercicios.Blog.dto.BlogDTO;
import com.ejercicios.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    IBlogService service;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDTO blog){
        return ResponseEntity.ok(service.createBlog(blog));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> allBlogs(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> blogById(@PathVariable int id){
        return ResponseEntity.ok(service.findById(id));
    }
}
