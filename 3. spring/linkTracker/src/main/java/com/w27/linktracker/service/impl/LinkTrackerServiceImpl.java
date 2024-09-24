package com.w27.linktracker.service.impl;

import com.w27.linktracker.dto.request.RequestLinkDTO;
import com.w27.linktracker.dto.response.ResponseLinkDTO;
import com.w27.linktracker.model.Link;
import com.w27.linktracker.repository.ILinkTrackerRepository;
import com.w27.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {
    @Autowired
    ILinkTrackerRepository repository;
    public ResponseLinkDTO createLink(RequestLinkDTO link){
        Link link = new Link()
    }
}
