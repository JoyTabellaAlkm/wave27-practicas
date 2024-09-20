package org.linktracker.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateLinkResponseDTO {
    @JsonProperty("url_shortened")
    private String urlShortened;
}
