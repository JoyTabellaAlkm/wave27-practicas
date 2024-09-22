package ar.com.linktracker.demo.repositories;

import ar.com.linktracker.demo.entities.Link;

public interface ILinkRepository {
    Long createLink(Link link);
    Link getLink(Long id);
    void updateLink(Long id, Link link);
    void deleteLink(Long id);
    Long getIdActual();
    void setIdActual(Long idActual);
}
