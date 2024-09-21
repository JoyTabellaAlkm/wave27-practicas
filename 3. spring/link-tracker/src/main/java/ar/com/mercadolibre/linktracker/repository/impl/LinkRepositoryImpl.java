package ar.com.mercadolibre.linktracker.repository.impl;

import ar.com.mercadolibre.linktracker.entity.Link;
import ar.com.mercadolibre.linktracker.exception.IdCreationException;
import ar.com.mercadolibre.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class LinkRepositoryImpl implements LinkRepository {
    private final Map<UUID, Link> links;

    public LinkRepositoryImpl() {
        links = new HashMap<>();
    }

    public UUID getFreeUUID() {
        for (int i = 0; i < 2; i++) {
            UUID id = UUID.randomUUID();

            if (!links.containsKey(id))
                return id;
        }

        throw new IdCreationException("No se encontró un UUID libre para crear el link.");
    }

    public void save(Link link) {
        links.put(link.getId(), link);
    }

    public Link getById(UUID linkId) {
        return links.get(linkId);
    }
}
