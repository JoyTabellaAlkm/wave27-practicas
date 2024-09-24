package com.w27.exceptionsblog.controller;

import com.w27.exceptionsblog.dto.BlogPostDTO;
import com.w27.exceptionsblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/blogs")
    ResponseEntity<?> getBlogs(){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.getAll());
    }

    @GetMapping("/blogs/{id}")
    ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.findById(id));
    }

    @PostMapping("/blog")
    ResponseEntity<?> postBlogEntry (@RequestBody BlogPostDTO post){
        Integer id = blogService.newPost(post);
        return ResponseEntity.status(HttpStatus.OK).body("El post se ha creado correctamente con el id: " +id);
    }

}
