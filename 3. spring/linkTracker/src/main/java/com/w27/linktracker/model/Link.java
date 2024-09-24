package com.w27.linktracker.model;

import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String link;
    private boolean valid;
    private Integer metrics;
    private String password;

    public Link(Integer id, String link, String password) {
        this.id = id;
        this.link = link;
        this.password = password;
        this.metrics = 0;
        this.password = null;
    }
}
