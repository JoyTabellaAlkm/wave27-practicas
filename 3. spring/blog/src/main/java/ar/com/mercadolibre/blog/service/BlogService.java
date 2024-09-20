package ar.com.mercadolibre.blog.service;

import ar.com.mercadolibre.blog.dto.BlogDto;
import ar.com.mercadolibre.blog.dto.CreateBlogDto;

import java.util.List;

public interface BlogService {
    BlogDto getById(Integer id);
    Integer create(CreateBlogDto blog);
    List<BlogDto> getAll();
}
