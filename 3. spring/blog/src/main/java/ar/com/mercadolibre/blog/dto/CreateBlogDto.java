package ar.com.mercadolibre.blog.dto;

public record CreateBlogDto(
        Integer id,
        String titulo,
        String autor
) { }
