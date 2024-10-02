package com.meli.clase17youtuberblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private String id;
    private String title;
    private String authorName;
    private LocalDate publishingDate;
}
