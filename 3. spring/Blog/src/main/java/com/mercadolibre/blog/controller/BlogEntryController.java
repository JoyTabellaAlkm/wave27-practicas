package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class BlogEntryController {

    @Autowired
    IBlogEntryService blogEntryService;

    @PostMapping("/blog")
    public String createBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO){
        return blogEntryService.CreateBlogEntry(blogEntryDTO);
    }

    @GetMapping("/blog/{id}")
    public BlogEntryDTO getBlogEntry(@PathVariable int id){
        return blogEntryService.getBlogEntry(id);
    }

    @GetMapping("/blogs")
    public Set<BlogEntryDTO> getBlogsEntry(){
        return blogEntryService.getBlogEntrys();
    }

}
