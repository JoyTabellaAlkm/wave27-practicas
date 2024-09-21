package ar.com.mercadolibre.linktracker.repository;

import ar.com.mercadolibre.linktracker.entity.Link;

import java.util.UUID;

public interface LinkRepository {
    UUID getFreeUUID();
    void save(Link link);
    Link getById(UUID linkId);
}
