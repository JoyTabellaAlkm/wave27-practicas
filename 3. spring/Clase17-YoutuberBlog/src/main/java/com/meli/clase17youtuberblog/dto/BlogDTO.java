package com.meli.clase17youtuberblog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogDTO {
    private String id;
    private String title;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("publishing_date")
    private LocalDate publishingDate;
}
