package ar.com.mercadolibre.linktracker.service;

import ar.com.mercadolibre.linktracker.dto.CreateLinkDto;

import java.util.UUID;

public interface LinkService {
    UUID create(CreateLinkDto link);
    String getLinkUrl(UUID linkId, String password);
    Integer getLinkRedirections(UUID linkId);
    void invalidateLink(UUID linkId);
}
