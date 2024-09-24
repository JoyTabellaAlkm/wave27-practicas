package com.w27.exceptionslibros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Book {
    @Getter
    private Long id;
    private String title;
    private String author;

}

