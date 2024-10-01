package ar.com.mercadolibre.socialmeli.dto.response;

import ar.com.mercadolibre.socialmeli.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"post_id", "date", "product", "category", "price", "has_promo", "discount"})
public class PostResponseDTO {

    @JsonProperty("post_id")
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;

    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;



}
