package ar.com.autosusados.autosusados.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
public class Servicio {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long kilometers;
    private String descriptions;
}
