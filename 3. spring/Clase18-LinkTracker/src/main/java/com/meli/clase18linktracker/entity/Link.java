package com.meli.clase18linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URI;

@Data
@AllArgsConstructor
public class Link {
    private URI link;
    private String password;
    private String id;
    private Integer visits;

    public void visit(){
        this.visits++;
    }
}
