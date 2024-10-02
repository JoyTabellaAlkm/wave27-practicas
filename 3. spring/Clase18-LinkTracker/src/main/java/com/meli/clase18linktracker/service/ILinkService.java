package com.meli.clase18linktracker.service;

import com.meli.clase18linktracker.dto.request.NewLinkDTO;
import com.meli.clase18linktracker.dto.response.LinkIdDTO;
import com.meli.clase18linktracker.dto.response.LinkMetricsDTO;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;

import java.net.URI;

public interface ILinkService {
    LinkIdDTO createLink(NewLinkDTO newLinkDTO);
    URI getLink(String id, String password) throws LinkNotFoundException, LinkNeedsAuthorization;
    LinkMetricsDTO showMetrics(String id, String password) throws LinkNotFoundException, LinkNeedsAuthorization;
    void invalidateLink(String id, String password) throws LinkNotFoundException, LinkNeedsAuthorization;
}
