package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentDTO {

    @NotNull(message = "El id no puede ser nulo.")
    @Min(value = 0,message = "El id debe ser mayor a 0.")
    Long id;

    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;

    @NotNull(message = "El mensaje no puede ser nulo.")
    String message;

    @NotNull(message = "El promedio no puede ser nulo.")
    @PositiveOrZero
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;
}
