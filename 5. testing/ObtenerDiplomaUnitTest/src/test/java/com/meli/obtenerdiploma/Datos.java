package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class Datos {
    public final static StudentDTO STUDENT = new StudentDTO(1L,"Leandro", List.of(new SubjectDTO(
            "Fisica",10.0), new SubjectDTO("Quimica",6.0)));
    public final static StudentDTO STUDENT_ID_NULL = new StudentDTO(null,"Daniela", List.of(new SubjectDTO(
            "Fisica",10.0), new SubjectDTO("Quimica",5.0)));
    public final static StudentDTO STUDENT_NONEXISTS = new StudentDTO(999L,"Luis", List.of(new SubjectDTO(
            "Fisica",7.0), new SubjectDTO("Quimica",5.0)));
    public final static StudentDTO STUDENT_DELETE = new StudentDTO(489L,"Amber", List.of(new SubjectDTO(
            "Fisica",3.0), new SubjectDTO("Quimica",5.0)));
    public final static StudentDTO STUDENT_PERFECT = new StudentDTO(489L,"Michael", List.of(new SubjectDTO(
            "Fisica",10.0), new SubjectDTO("Quimica",10.0)));
}
