package com.meli.clase18linktracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URI;

@Data
@AllArgsConstructor
public class NewLinkDTO {
    private String link;
    private String password;
}
