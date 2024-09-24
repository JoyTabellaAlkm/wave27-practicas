package com.w27.linktracker.service;

import com.w27.linktracker.dto.request.RequestLinkDTO;
import com.w27.linktracker.dto.response.ResponseLinkDTO;

public interface ILinkTrackerService {
    public ResponseLinkDTO createLink(RequestLinkDTO link);
}
