package com.w27.linktracker.repository.impl;

import com.w27.linktracker.model.Link;
import com.w27.linktracker.repository.ILinkTrackerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {

    HashMap<Integer, Link> linksMap = new HashMap<>();

    @Override
    public Integer create(Link link) {
        Integer id = link.getId();
        linksMap.put(id, link);
        return id;
    }

    @Override
    public Link getMetrics(Integer linkId) {
        return null;
    }

    @Override
    public Link invalidate(Link link) {
        return null;
    }
}
