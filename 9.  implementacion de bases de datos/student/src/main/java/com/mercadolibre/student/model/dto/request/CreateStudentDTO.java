package com.mercadolibre.student.model.dto.request;


import lombok.Data;

@Data
public class CreateStudentDTO {


    private String name;
    private String lastName;
    private String dni;

}
