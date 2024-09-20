package com.ejercicios.Blog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogDTO {
    private int id;
    private String titulo;
    private String autor;
    @JsonProperty("fecha_publicacion")
    private String fechaPublicacion;
}
