package ar.com.mercadolibre.link.service.impl;

import ar.com.mercadolibre.link.exception.InvalidLinkException;
import ar.com.mercadolibre.link.exception.LinkNotFoundException;
import ar.com.mercadolibre.link.model.Link;
import ar.com.mercadolibre.link.model.dto.request.LinkRequestDTO;
import ar.com.mercadolibre.link.model.dto.response.LinkResponseDTO;
import ar.com.mercadolibre.link.repository.LinkRepository;
import ar.com.mercadolibre.link.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    LinkRepository linkRepository;

    private static final String URL_REGEX = "^[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$";

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);


    public Integer saveLink(LinkRequestDTO link) {

        if (!isValidURL(link.getUrl())){
            throw new InvalidLinkException("INVALID URL!");
        }

        Integer id = linkRepository.getNextId();

        linkRepository.saveLink(new Link(id, link.getUrl(), 0, true, link.getPassword()));

        return id;
    }

    public LinkResponseDTO redirect(Integer id, String password){

        if (!linkRepository.existId(id)){
            throw new LinkNotFoundException(String.format("No existe un Link con el ID = %d", id));
        }

        Link link = linkRepository.getLinkById(id);

        if (!link.getValid()) {
            throw  new InvalidLinkException(String.format("El link con el ID = %d es invalido", id));
        }

        if (link.getPassword() != null && !link.getPassword().equals(password)){
            throw  new InvalidLinkException("CONTRASEÑA INVALIDA");
        }

        linkRepository.incrementMetrics(link);

        return new LinkResponseDTO(link.getLink(), link.getMetrics(), link.getValid());
    }

    public Integer metricsById(Integer id){

        if (!linkRepository.existId(id)){
            throw new LinkNotFoundException(String.format("No existe un Link con el ID = %d", id));
        }

        Link link = linkRepository.getLinkById(id);

        return link.getMetrics();
    }

    public void invalidateLink(Integer id){

        if (!linkRepository.existId(id)){
            throw new LinkNotFoundException(String.format("No existe un Link con el ID = %d", id));
        }

        Link link = linkRepository.getLinkById(id);

        linkRepository.invalidateLink(link);
    }


    private boolean isValidURL(String url) {
        if (url == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }



}
