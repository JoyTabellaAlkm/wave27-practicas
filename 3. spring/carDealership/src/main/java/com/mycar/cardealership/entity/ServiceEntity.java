package com.mycar.cardealership.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class ServiceEntity {
    private Long id;
    private String date;
    private String kilometers;
    private String descriptions;
}
