package org.linktracker.repositories;

import org.linktracker.entities.Link;
import org.springframework.stereotype.Repository;
import org.sqids.Sqids;

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
