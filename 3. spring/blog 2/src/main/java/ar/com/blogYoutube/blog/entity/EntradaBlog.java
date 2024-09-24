package ar.com.blogYoutube.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private String id;
    private String título;
    private String nombreAutor;
    private Date fechaPublicacion;
}