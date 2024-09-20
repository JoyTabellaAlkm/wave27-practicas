package org.linktracker.dtos;

import lombok.Data;

@Data
public class CreateLinkDTO {
    private String URL;
    private String password;
}
