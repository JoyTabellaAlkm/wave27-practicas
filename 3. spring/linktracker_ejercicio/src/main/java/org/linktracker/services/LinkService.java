package org.linktracker.services;

import org.linktracker.dtos.CreateLinkDTO;
import org.linktracker.entities.Link;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.linktracker.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

@Service
public class LinkService implements ILinkService {
    @Autowired
    private ILinkRepository linkRepository;

    URI validateURL(String url) throws LinkIsInvalid {
        try {
            return new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new LinkIsInvalid();
        }
    }

    Boolean handleAuth(Link link, String userPassword){
        if(link.getPassword() == null){
            return true;
        }
        else{
            return link.getPassword().equals(userPassword);
        }
    }

    @Override
    public UUID createLink(CreateLinkDTO dto) throws LinkIsInvalid {
        Link link = new Link(validateURL(dto.getURL()), dto.getPassword());
        return this.linkRepository.createLink(link);
    }

    @Override
    public URI getLink(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Link link = this.linkRepository.getLink(id);

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorization();
        }

        link.incrementVisits(); //for metrics
        linkRepository.updateLink(id, link);
        return link.getUrl();
    }


    @Override
    public Integer getLinkMetrics(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Link link = this.linkRepository.getLink(id);

        if(link == null) {
            throw new LinkNotFound();
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorization();
        }

        return link.getVisits();

    }

    @Override
    public void invalidateLink(UUID id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Link link = this.linkRepository.getLink(id);

        if(link == null) {
            throw new LinkNotFound();
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorization();
        }

        this.linkRepository.deleteLink(id);
    }
}
