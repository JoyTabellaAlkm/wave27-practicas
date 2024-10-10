package ar.com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"post_id", "user_id"})
public class SearchResponseDTO {
    @JsonProperty("post_id")
    private Integer postId;

    private ProductResponseDTO product;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Integer category;

    private Double price;

    @JsonProperty("has_promo")
    private Boolean hasPromo;

    private Double discount;

    @JsonProperty("user_id")
    private Integer userId;
}
