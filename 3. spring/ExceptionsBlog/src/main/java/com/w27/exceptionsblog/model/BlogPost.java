package com.w27.exceptionsblog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogPost {
    private Integer id;
    private String title;
    private String authorName;
    private LocalDateTime date;

    public BlogPost(String title, String authorName) {
        this.title = title;
        this.authorName = authorName;
    }
}
