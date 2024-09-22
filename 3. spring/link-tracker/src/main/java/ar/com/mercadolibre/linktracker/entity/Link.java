package ar.com.mercadolibre.linktracker.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Link {
    private UUID id;
    private String url;
    private String password;
    private Integer redirections;
    private Boolean isValid;

    public Link(UUID id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.redirections = 0;
        this.isValid = true;
    }

    public void incrementRedirections() {
        redirections++;
    }

    public void invalidate() {
        isValid = false;
    }
}
