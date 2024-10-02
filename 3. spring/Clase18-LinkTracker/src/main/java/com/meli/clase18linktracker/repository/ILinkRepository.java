package com.meli.clase18linktracker.repository;

import com.meli.clase18linktracker.entity.Link;
import com.meli.clase18linktracker.exception.LinkNeedsAuthorization;
import com.meli.clase18linktracker.exception.LinkNotFoundException;

public interface ILinkRepository {
    void createLink(Link link);

    Link getLink(String id) throws LinkNotFoundException;

    void deleteLink(String id);

}
