package ar.com.mercadolibre.blog.service.impl;

import ar.com.mercadolibre.blog.exception.NotFoundException;
import ar.com.mercadolibre.blog.dto.BlogDto;
import ar.com.mercadolibre.blog.dto.CreateBlogDto;
import ar.com.mercadolibre.blog.entity.EntradaBlog;
import ar.com.mercadolibre.blog.repository.BlogRepository;
import ar.com.mercadolibre.blog.service.BlogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogDto getById(Integer id) {
        EntradaBlog blog = blogRepository.getById(id);

        if (blog == null) {
            throw new NotFoundException("No se encontró el blog con el id " + id);
        }

        return mapBlogToBlogDto(blog);
    }

    public Integer create(CreateBlogDto blog) {
        EntradaBlog savedBlog = new EntradaBlog(blog.id(), blog.titulo(), blog.autor(), LocalDate.now());
        blogRepository.save(savedBlog);
        return blog.id();
    }

    public List<BlogDto> getAll() {
        return blogRepository.getAll().stream().map(this::mapBlogToBlogDto).toList();
    }

    private BlogDto mapBlogToBlogDto(EntradaBlog blog) {
        return new BlogDto(blog.getId(), blog.getTitulo(), blog.getAutor(), blog.getFecha());
    }
}
