package com.mercadolibre.empleados.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String departamento;

}
