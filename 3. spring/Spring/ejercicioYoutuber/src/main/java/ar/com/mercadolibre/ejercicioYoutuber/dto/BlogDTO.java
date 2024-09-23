package ar.com.mercadolibre.ejercicioYoutuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private int id;
    private String titulo;
    private String autor;
}
