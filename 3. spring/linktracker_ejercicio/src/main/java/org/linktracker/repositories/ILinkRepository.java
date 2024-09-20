package org.linktracker.repositories;

import org.linktracker.entities.Link;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;

import java.net.URI;
import java.util.UUID;

public interface ILinkRepository {
    UUID createLink(Link link);

    Link getLink(UUID id) throws LinkNotFound, LinkNeedsAuthorization;

    void updateLink(UUID id, Link link);

    void deleteLink(UUID id);
}
