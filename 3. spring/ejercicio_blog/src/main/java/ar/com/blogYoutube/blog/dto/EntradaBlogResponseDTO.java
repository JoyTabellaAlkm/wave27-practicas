package ar.com.blogYoutube.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EntradaBlogResponseDTO {
    private String id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
