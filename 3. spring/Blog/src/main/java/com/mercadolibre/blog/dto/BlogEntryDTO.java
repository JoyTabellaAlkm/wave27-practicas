package com.mercadolibre.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BlogEntryDTO implements Serializable {

    private int id;
    private String title;
    private String authorName;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
