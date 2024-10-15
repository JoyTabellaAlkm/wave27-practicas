package ar.com.mercadolibre.socialmeli2.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PromoCountDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String username;
    @JsonProperty("promo_products_count")
    private int promoProductsCount;
}
