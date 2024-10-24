package ar.com.mercadolibre.clothes.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SalesResponseDto {
    private LocalDate date;
    private BigDecimal total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<ClothesResponseSaleDto> clothes;
}
