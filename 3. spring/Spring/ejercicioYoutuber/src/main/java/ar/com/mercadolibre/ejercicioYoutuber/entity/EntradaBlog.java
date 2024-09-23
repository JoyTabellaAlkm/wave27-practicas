package ar.com.mercadolibre.ejercicioYoutuber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private LocalDate fecha;

    public EntradaBlog(int id, String titulo, String autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = LocalDate.now();
    }
}
