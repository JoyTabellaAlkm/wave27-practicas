package com.ejercicios.Blog.service;

import com.ejercicios.Blog.dto.BlogDTO;
import com.ejercicios.Blog.entity.Blog;

import java.util.List;

public interface IBlogService {

    String createBlog(BlogDTO blog);
    List<BlogDTO> findAll();
    BlogDTO findById(int id);
}
