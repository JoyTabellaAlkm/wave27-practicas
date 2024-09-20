package org.linktracker.services;

import org.linktracker.dtos.CreateLinkDTO;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;

import java.net.URI;
import java.util.UUID;

public interface ILinkService {
    UUID createLink(CreateLinkDTO url) throws LinkIsInvalid;

    URI getLink(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization;

    Integer getLinkMetrics(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization;

    void invalidateLink(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization;
}
