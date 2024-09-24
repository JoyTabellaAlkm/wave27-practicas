package com.w27.linktracker.controller;

import com.w27.linktracker.dto.request.RequestLinkDTO;
import com.w27.linktracker.repository.ILinkTrackerRepository;
import com.w27.linktracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkRestController {
    @Autowired
    ILinkTrackerRepository repository;

    @Autowired
    ILinkTrackerService service;

   @PostMapping("/link")
   public ResponseEntity<?> createLink (@RequestBody RequestLinkDTO link){
       return ResponseEntity.status(HttpStatus.OK).body(service.createLink(link));
    }

}
