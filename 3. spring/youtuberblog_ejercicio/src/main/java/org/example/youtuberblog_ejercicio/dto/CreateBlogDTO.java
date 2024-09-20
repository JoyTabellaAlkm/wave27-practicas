package org.example.youtuberblog_ejercicio.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateBlogDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
