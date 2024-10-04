package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String description;
    @JsonProperty("messages_list")
    private List<String> messagesList;
}
