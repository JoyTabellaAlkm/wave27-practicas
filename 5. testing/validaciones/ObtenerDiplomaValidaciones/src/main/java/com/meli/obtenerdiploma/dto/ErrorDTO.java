package com.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDTO {
    String description;
    List<String> errores;
}
