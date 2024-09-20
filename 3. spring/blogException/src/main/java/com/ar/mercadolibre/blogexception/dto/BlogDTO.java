package com.ar.mercadolibre.blogexception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class BlogDTO {
    private int id;
    private String title;
    private String author;
    private LocalDate date;
}
