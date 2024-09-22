package ar.com.linktracker.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateLinkDTO {
    @JsonProperty("url_shortened")
    private String urlShortened;
}