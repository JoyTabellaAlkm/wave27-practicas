package com.meli.ejconcesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private long kilometers;
    private String descriptions;
}
