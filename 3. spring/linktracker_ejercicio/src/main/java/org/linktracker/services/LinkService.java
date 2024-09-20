package org.linktracker.services;

import org.linktracker.dtos.CreateLinkRequestDTO;
import org.linktracker.dtos.CreateLinkResponseDTO;
import org.linktracker.entities.Link;
import org.linktracker.exceptions.LinkIsInvalid;
import org.linktracker.exceptions.LinkNeedsAuthorization;
import org.linktracker.exceptions.LinkNotFound;
import org.linktracker.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class LinkService implements ILinkService {
    Sqids sqids;

    @Autowired
    private ILinkRepository linkRepository;

    public LinkService(){
        sqids = Sqids.builder().alphabet("FxnXM1kBN6cuhsAvjW3Co7l2RePyY8DwaU04Tzt9fHQrqSVKdpimLGIJOgb5ZE").minLength(10).build();
    }

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
    public CreateLinkResponseDTO createLink(CreateLinkRequestDTO requestDto) throws LinkIsInvalid {
        Long idActual = linkRepository.getIdActual();
        linkRepository.setIdActual(idActual++);
        Link link = new Link(idActual, validateURL(requestDto.getURL()), requestDto.getPassword());
        this.linkRepository.createLink(link);
        String urlShortened = sqids.encode(List.of(linkRepository.getIdActual()));
        CreateLinkResponseDTO responseDto = new CreateLinkResponseDTO();
        responseDto.setUrlShortened(urlShortened);
        return responseDto;
    }

    @Override
    public URI getLink(String id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Long idNumerico = sqids.decode(id).getFirst();
        Link link = this.linkRepository.getLink(idNumerico);

        if(link == null) {
            throw new LinkNotFound();
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorization();
        }

        link.incrementVisits(); //for metrics
        linkRepository.updateLink(idNumerico, link);
        return link.getUrl();
    }


    @Override
    public Integer getLinkMetrics(String id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Long idNumerico = sqids.decode(id).getFirst();

        Link link = this.linkRepository.getLink(idNumerico);

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
    public void invalidateLink(String id, String password) throws LinkNotFound, LinkNeedsAuthorization {
        Long idNumerico = sqids.decode(id).getFirst();
        Link link = this.linkRepository.getLink(idNumerico);

        if(link == null) {
            throw new LinkNotFound();
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorization();
        }

        this.linkRepository.deleteLink(idNumerico);
    }
}
