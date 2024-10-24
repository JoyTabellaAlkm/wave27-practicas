package ar.com.mercadolibre.clothes.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SalesRequestDto {

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate date;

    @NotNull(message = "El total no puede ser nulo")
    @Positive(message = "El total debe ser un número positivo")
    private BigDecimal total;

    @NotBlank(message = "El método de pago no puede estar vacío")
    private String paymentMethod;

    @NotEmpty(message = "La lista de prendas no puede estar vacía")
    private List<ClothesRequestSaleDto> clothes;
}

