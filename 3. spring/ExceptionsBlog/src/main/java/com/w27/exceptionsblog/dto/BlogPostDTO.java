package com.w27.exceptionsblog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDTO {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDateTime date;

    public BlogPostDTO(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }

    public BlogPostDTO(Integer id, String title, String authorName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
    }
}
