package com.meli.linktracker.repository.impl;

import com.meli.linktracker.entity.Link;
import com.meli.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LinkRepository implements ILinkRepository {

    @Override
    public String createLink(Link link) {
        return "";
    }
}
