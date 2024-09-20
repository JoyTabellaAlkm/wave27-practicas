package org.linktracker.services;

import org.linktracker.dtos.CreateLinkRequestDTO;
import org.linktracker.dtos.CreateLinkResponseDTO;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;

import java.net.URI;

public interface ILinkService {
    CreateLinkResponseDTO createLink(CreateLinkRequestDTO url) throws LinkIsInvalid;

    URI getLink(String id, String password) throws LinkNotFound, LinkNeedsAuthorization;

    Integer getLinkMetrics(String id, String password) throws LinkNotFound, LinkNeedsAuthorization;

    void invalidateLink(String id, String password) throws LinkNotFound, LinkNeedsAuthorization;
}
