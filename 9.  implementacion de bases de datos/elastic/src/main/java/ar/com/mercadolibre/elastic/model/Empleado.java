package ar.com.mercadolibre.elastic.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleado")
@Data
public class Empleado {

    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;

}
