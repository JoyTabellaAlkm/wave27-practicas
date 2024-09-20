package ar.com.mercadolibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fecha;
}
