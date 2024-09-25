package com.example.calculatecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDto {
    public String name;
    public Integer calories;
}
