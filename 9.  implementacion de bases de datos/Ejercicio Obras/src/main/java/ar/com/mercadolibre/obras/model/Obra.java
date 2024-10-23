package ar.com.mercadolibre.obras.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras")
@Data
public class Obra {

    @Id
    private Integer id;
    private String nombre;
    private String autor;
    private Integer paginas;
    private String editorial;
    private Integer anioPublicacion;

}
