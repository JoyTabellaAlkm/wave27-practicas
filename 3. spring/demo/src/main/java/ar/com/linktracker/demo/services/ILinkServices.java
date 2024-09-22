package ar.com.linktracker.demo.services;

import ar.com.linktracker.demo.dtos.CreateLinkDTO;
import ar.com.linktracker.demo.dtos.CreateLinkRequestDTO;

import java.net.URI;

public interface ILinkServices {
    CreateLinkDTO createLink(CreateLinkRequestDTO url) ;
    URI getLink(String id, String password);
    Integer getLinkMetrics(String id, String password);
    void invalidateLink(String id, String password);
}
