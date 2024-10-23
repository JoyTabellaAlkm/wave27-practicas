package ar.com.mercadolibre.empleados.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Setter
@Document(indexName = "empleados")
public class Empleado {
    @Id
    private Long id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String apellido;
    @Field(type = FieldType.Integer)
    private Integer edad;
    @Field(type = FieldType.Text)
    private String ciudad;
    @Field(type = FieldType.Text)
    private String provincia;
    @Field(type = FieldType.Text)
    private String estado;
}
