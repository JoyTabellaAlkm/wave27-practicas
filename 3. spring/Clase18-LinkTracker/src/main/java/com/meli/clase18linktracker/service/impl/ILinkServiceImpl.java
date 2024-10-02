package com.meli.clase18linktracker.service.impl;

import com.meli.clase18linktracker.dto.request.NewLinkDTO;
import com.meli.clase18linktracker.dto.response.LinkIdDTO;
import com.meli.clase18linktracker.dto.response.LinkMetricsDTO;
import com.meli.clase18linktracker.entity.Link;
import com.meli.clase18linktracker.exception.InvalidLinkException;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;
import com.meli.clase18linktracker.repository.LinkRepository;
import com.meli.clase18linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqids.Sqids;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class ILinkServiceImpl implements ILinkService {
    Sqids sqids;
    Long idCounter = 0L;

    @Autowired
    LinkRepository linkRepository;

    public ILinkServiceImpl(){
        sqids = Sqids.builder().minLength(10).build();
    }

    URI validateURL(String url) throws InvalidLinkException {
        try {
            return new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidLinkException();
        }
    }

    String generateID(){
        idCounter++;
        return sqids.encode(List.of(idCounter));
    }

    @Override
    public LinkIdDTO createLink(NewLinkDTO newLinkDTO) {
        String idNuevo = generateID();
        linkRepository.createLink(new Link(validateURL(newLinkDTO.getLink()), newLinkDTO.getPassword(), idNuevo, 0));
        return new LinkIdDTO(idNuevo);
    }

    @Override
    public URI getLink(String id, String password) throws LinkNotFoundException, LinkNeedsAuthorization {
        if(linkRepository.getLink(id) == null){
            throw new LinkNotFoundException();
        } else if (linkRepository.getLink(id).getPassword() != null) {
            if (linkRepository.getLink(id).getPassword().equals(password)){
                linkRepository.getLink(id).visit();
                return linkRepository.getLink(id).getLink();
            }  else  {
                throw new LinkNeedsAuthorization();
            }
        } else {
            linkRepository.getLink(id).visit();
            return linkRepository.getLink(id).getLink();
        }
    }

    @Override
    public LinkMetricsDTO showMetrics(String id, String password) throws LinkNotFoundException, LinkNeedsAuthorization {
        if(linkRepository.getLink(id) == null){
            throw new LinkNotFoundException();
        } else if (linkRepository.getLink(id).getPassword() != null) {
            if (linkRepository.getLink(id).getPassword().equals(password)){
                return new LinkMetricsDTO(linkRepository.getLink(id).getLink(), id, linkRepository.getLink(id).getVisits());
            }  else  {
                throw new LinkNeedsAuthorization();
            }
        } else {
            return new LinkMetricsDTO(linkRepository.getLink(id).getLink(), id, linkRepository.getLink(id).getVisits());
        }
    }

    @Override
    public void invalidateLink(String id,  String password ) throws LinkNotFoundException, LinkNeedsAuthorization{
        if(linkRepository.getLink(id) == null){
            throw new LinkNotFoundException();
        } else if (linkRepository.getLink(id).getPassword() != null) {
            if (linkRepository.getLink(id).getPassword().equals(password)){
                linkRepository.deleteLink(id);
            }  else  {
                throw new LinkNeedsAuthorization();
            }
        } else {
            linkRepository.deleteLink(id);
        }
    }
}
