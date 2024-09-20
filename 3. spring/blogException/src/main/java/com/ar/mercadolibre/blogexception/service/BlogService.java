package com.ar.mercadolibre.blogexception.service;

import com.ar.mercadolibre.blogexception.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    String createBlog(BlogDTO blogDTO);

    BlogDTO findBlogById(int id);

    List<BlogDTO> findAll();
}
