package ar.com.linktracker.demo.entities;

import lombok.Getter;

import java.net.URI;

@Getter
public class Link {
    private URI url;
    private Integer visits;
    private String password;
    private Long id;

    public Link(Long id, URI url){
        this.id = id;
        this.url = url;
        this.password = null;
        visits = 0;
    }

    public Link(Long id, URI url, String password){
        this.id = id;
        this.url = url;
        this.password = password;
        visits = 0;
    }

    public void incrementVisits(){
        visits++;
    }
}