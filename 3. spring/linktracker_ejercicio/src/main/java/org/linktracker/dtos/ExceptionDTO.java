package org.linktracker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ExceptionDTO{
    private String error_description;
    private Integer status_code;
}
