package ar.com.mercadolibre.socialmeli.dto.request;

import ar.com.mercadolibre.socialmeli.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePromoRequestDTO {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Product product;
    private Integer category;
    private Double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private Double discount;
}
