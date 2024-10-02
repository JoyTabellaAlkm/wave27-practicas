package com.meli.clase18linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.URI;

@Data
@AllArgsConstructor
public class LinkMetricsDTO {
    private URI link;
    private String id;
    private Integer visits;
}
