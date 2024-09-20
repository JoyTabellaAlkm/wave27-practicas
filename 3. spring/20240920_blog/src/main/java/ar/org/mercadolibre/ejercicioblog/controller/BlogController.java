package ar.org.mercadolibre.ejercicioblog.controller;

import ar.org.mercadolibre.ejercicioblog.dto.BlogDto;
import ar.org.mercadolibre.ejercicioblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> createBlog(@RequestBody BlogDto blog){
        return new ResponseEntity<>(blogService.createBlog(blog), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> allBlogs(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<?> blogById(@PathVariable int id){
        return ResponseEntity.ok(blogService.findById(id));

    }

}
