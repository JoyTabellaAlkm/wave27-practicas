package ar.com.mercadolibre.blog.controller;

import ar.com.mercadolibre.blog.model.BlogEntry;
import ar.com.mercadolibre.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogEntryController {

    @Autowired
    IBlogEntryService blogEntryService;


    @PostMapping("/blog")
    public ResponseEntity<?> saveBlogEntry(@RequestBody BlogEntry entry){

        return ResponseEntity.ok(blogEntryService.saveBlogEntry(entry));

    }


    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlogEntryById(@PathVariable Integer id){

        return ResponseEntity.ok(blogEntryService.getBlogEntryById(id));

    }


    @GetMapping("/blogs")
    public ResponseEntity<?> getAllBlogs(){

        return ResponseEntity.ok(blogEntryService.getAllBlogEntries());

    }
}
