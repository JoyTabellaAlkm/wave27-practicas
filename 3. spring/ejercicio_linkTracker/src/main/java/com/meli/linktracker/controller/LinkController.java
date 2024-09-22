package com.meli.linktracker.controller;

import com.meli.linktracker.dto.LinkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {


        public ResponseEntity<?> createLink(@RequestBody LinkDTO linkDTO)
        {
            return new ResponseEntity<>("", HttpStatus.OK);
        }

}
