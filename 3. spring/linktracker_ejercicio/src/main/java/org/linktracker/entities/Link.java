package org.linktracker.entities;

import lombok.Getter;

import java.net.URI;

@Getter
public class Link {
    private URI url;
    private Integer visits;
    private String password;
    public Link(URI url){
        this.url = url;
        this.password = null;
        visits = 0;
    }

    public Link(URI url, String password){
        this.url = url;
        this.password = password;
        visits = 0;
    }

    public void incrementVisits(){
        visits++;
    }
}
