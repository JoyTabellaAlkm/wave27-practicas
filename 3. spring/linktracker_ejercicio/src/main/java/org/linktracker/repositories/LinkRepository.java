package org.linktracker.repositories;

import org.linktracker.entities.Link;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class LinkRepository implements ILinkRepository {
    private final Map<UUID, Link> links;

    public LinkRepository() {
        links = new HashMap<>();
    }
    @Override
    public UUID createLink(Link link) {
        UUID id = UUID.randomUUID();
        links.put(id, link);
        return id;
    }

    @Override
    public Link getLink(UUID id) {
        return links.get(id);
    }

    @Override
    public void updateLink(UUID id, Link link) {
        links.put(id, link);
    }

    @Override
    public void deleteLink(UUID id) {
        links.remove(id);
    }
}
