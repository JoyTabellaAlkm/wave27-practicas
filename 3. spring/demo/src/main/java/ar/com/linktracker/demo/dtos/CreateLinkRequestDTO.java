package ar.com.linktracker.demo.dtos;

import lombok.Data;

@Data
public class CreateLinkRequestDTO {
    private  String URL;
    private String password;
}
