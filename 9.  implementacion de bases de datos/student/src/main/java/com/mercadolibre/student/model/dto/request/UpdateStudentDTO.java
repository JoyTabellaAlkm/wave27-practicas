package com.mercadolibre.student.model.dto.request;

import lombok.Data;

@Data
public class UpdateStudentDTO {

    private Long id;
    private String name;
    private String lastName;
    private String dni;
}
