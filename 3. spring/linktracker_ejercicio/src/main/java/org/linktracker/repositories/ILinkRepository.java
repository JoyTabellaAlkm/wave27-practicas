package org.linktracker.repositories;

import org.linktracker.entities.Link;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;

import java.util.UUID;

public interface ILinkRepository {
    Long createLink(Link link);

    Link getLink(Long id) throws LinkNotFound, LinkNeedsAuthorization;

    void updateLink(Long id, Link link);

    void deleteLink(Long id);

    Long getIdActual();
    void setIdActual(Long idActual);
}
