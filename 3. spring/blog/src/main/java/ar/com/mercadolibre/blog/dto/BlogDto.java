package ar.com.mercadolibre.blog.dto;

import java.time.LocalDate;

public record BlogDto(
        Integer id,
        String titulo,
        String autor,
        LocalDate fecha
) { }
