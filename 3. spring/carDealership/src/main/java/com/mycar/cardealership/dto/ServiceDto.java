package com.mycar.cardealership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ServiceDto {
    private String date;
    private Integer kilometers;
    private String description;
}
