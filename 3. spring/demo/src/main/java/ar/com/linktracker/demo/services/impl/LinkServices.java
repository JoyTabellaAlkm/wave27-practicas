package ar.com.linktracker.demo.services.impl;

import ar.com.linktracker.demo.dtos.CreateLinkDTO;
import ar.com.linktracker.demo.dtos.CreateLinkRequestDTO;
import ar.com.linktracker.demo.entities.Link;
import ar.com.linktracker.demo.exceptions.LinkInvalidExceptions;
import ar.com.linktracker.demo.exceptions.LinkNeedsAuthorizationException;
import ar.com.linktracker.demo.exceptions.LinkNotFoundException;
import ar.com.linktracker.demo.repositories.ILinkRepository;
import ar.com.linktracker.demo.services.ILinkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class LinkServices implements ILinkServices {
    Sqids sqids;

    @Autowired
    private ILinkRepository linkRepository;

    public LinkServices(){
        sqids = Sqids.builder().alphabet("FxnXM1kBN6cuhsAvjW3Co7l2RePyY8DwaU04Tzt9fHQrqSVKdpimLGIJOgb5ZE").minLength(10).build();
    }

    private URI validateURL(String url) {
        try {
            return new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new LinkInvalidExceptions();
        }
    }

    private Boolean handleAuth(Link link, String userPassword){
        if(link.getPassword() == null){
            return true;
        }
        else{
            return link.getPassword().equals(userPassword);
        }
    }

    @Override
    public CreateLinkDTO createLink(CreateLinkRequestDTO requestDto) {
        Long idActual = linkRepository.getIdActual();
        linkRepository.setIdActual(idActual++);
        Link link = new Link(idActual, validateURL(requestDto.getURL()), requestDto.getPassword());
        this.linkRepository.createLink(link);
        String urlShortened = sqids.encode(List.of(linkRepository.getIdActual()));
        CreateLinkDTO responseDto = new CreateLinkDTO();
        responseDto.setUrlShortened(urlShortened);
        return responseDto;
    }

    @Override
    public URI getLink(String id, String password) {
        Long idNumerico = sqids.decode(id).getFirst();
        Link link = this.linkRepository.getLink(idNumerico);

        if(link == null) {
            try {
                throw new LinkNotFoundException();
            } catch (LinkNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorizationException();
        }

        link.incrementVisits(); //for metrics
        linkRepository.updateLink(idNumerico, link);
        return link.getUrl();
    }


    @Override
    public Integer getLinkMetrics(String id, String password){
        Long idNumerico = sqids.decode(id).getFirst();

        Link link = this.linkRepository.getLink(idNumerico);

        if(link == null) {
            try {
                throw new LinkNotFoundException();
            } catch (LinkNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorizationException();
        }

        return link.getVisits();
    }

    @Override
    public void invalidateLink(String id, String password) {
        Long idNumerico = sqids.decode(id).getFirst();
        Link link = this.linkRepository.getLink(idNumerico);

        if(link == null) {
            throw new LinkInvalidExceptions();
        }

        Boolean authOk = handleAuth(link, password);
        if(!authOk){
            throw new LinkNeedsAuthorizationException();
        }

        this.linkRepository.deleteLink(idNumerico);
    }
}
