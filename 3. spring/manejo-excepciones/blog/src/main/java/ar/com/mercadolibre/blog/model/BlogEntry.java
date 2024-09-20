package ar.com.mercadolibre.blog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    @JsonProperty("release-date")
    private String releaseDate;
}
