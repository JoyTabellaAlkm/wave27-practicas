package org.example.youtuberblog_ejercicio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
