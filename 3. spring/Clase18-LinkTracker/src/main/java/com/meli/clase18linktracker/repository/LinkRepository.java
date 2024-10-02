package com.meli.clase18linktracker.repository;

import com.meli.clase18linktracker.entity.Link;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Getter
@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<String, Link> linksRepository = new HashMap<>();

    @Override
    public void createLink(Link link) {
        linksRepository.put(link.getId(), link);
    }

    @Override
    public Link getLink(String id) throws LinkNotFoundException {
        if(linksRepository.get(id) == null){
            throw new LinkNotFoundException();
        } else {
            return linksRepository.get(id);
        }
    }

    @Override
    public void deleteLink(String id) {
        linksRepository.remove(id);
    }
}
