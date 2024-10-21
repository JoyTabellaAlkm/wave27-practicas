package ar.com.mercadolibre.clavescompuestas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraKey implements Serializable {
    private Long id;
    private LocalDate fecha;
}
