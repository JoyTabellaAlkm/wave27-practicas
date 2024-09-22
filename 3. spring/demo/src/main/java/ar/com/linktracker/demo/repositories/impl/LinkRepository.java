package ar.com.linktracker.demo.repositories.impl;

import ar.com.linktracker.demo.entities.Link;
import ar.com.linktracker.demo.repositories.ILinkRepository;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class LinkRepository implements ILinkRepository {
    private Long idActual;

    public LinkRepository(){
        links = new HashMap<>();
        idActual = 0L;
    }
    private final Map<Long, Link> links;

    @Override
    public Long createLink(Link link) {
        idActual++;
        links.put(link.getId(), link);
        return idActual;
    }

    @Override
    public Link getLink(Long id) {
        return links.get(id);
    }

    @Override
    public void updateLink(Long id, Link link) {
        links.put(id, link);
    }

    @Override
    public void deleteLink(Long id) {
        links.remove(id);
    }

    @Override
    public Long getIdActual() {
        return idActual;
    }

    @Override
    public void setIdActual(Long idActual) {
        this.idActual = idActual;
    }
}