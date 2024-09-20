package ar.com.mercadolibre.linktracker.service.impl;

import ar.com.mercadolibre.linktracker.dto.CreateLinkDto;
import ar.com.mercadolibre.linktracker.entity.Link;
import ar.com.mercadolibre.linktracker.exception.AuthenticationException;
import ar.com.mercadolibre.linktracker.exception.InvalidLinkException;
import ar.com.mercadolibre.linktracker.exception.NotFoundException;
import ar.com.mercadolibre.linktracker.repository.LinkRepository;
import ar.com.mercadolibre.linktracker.service.LinkService;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public UUID create(CreateLinkDto linkDto) {
        Link link = new Link(
                linkRepository.getFreeUUID(),
                linkDto.url(),
                hashPassword(linkDto.password()));

        linkRepository.save(link);

        return link.getId();
    }

    public String getLinkUrl(UUID linkId, String password) {
        Link link = getLink(linkId);

        if (!link.getPassword().equals(hashPassword(password))) {
            throw new AuthenticationException("La contraseña es incorrecta.");
        }

        if (!link.getIsValid()) {
            throw new InvalidLinkException("El link fue invalidado.");
        }

        link.incrementRedirections();
        linkRepository.save(link);

        return link.getUrl();
    }

    public Integer getLinkRedirections(UUID linkId) {
        Link link = getLink(linkId);

        return link.getRedirections();
    }

    public void invalidateLink(UUID linkId) {
        Link link = getLink(linkId);

        link.invalidate();
        linkRepository.save(link);
    }

    private String hashPassword(String password) {
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    private Link getLink(UUID linkId) {
        Link link = linkRepository.getById(linkId);

        if (link == null) {
            throw new NotFoundException("No existe un link con el id " + linkId.toString());
        }

        return link;
    }
}
