package ar.com.mercadolibre.clothes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Sales {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private BigDecimal total;
    private String paymentMethod;
    @ManyToMany
    @JoinTable(
        name="sales_clothes",
            joinColumns = @JoinColumn(name="sales_id"),
            inverseJoinColumns = @JoinColumn(name="clothes_id")
    )
    private List<Clothes> clothes;

}
