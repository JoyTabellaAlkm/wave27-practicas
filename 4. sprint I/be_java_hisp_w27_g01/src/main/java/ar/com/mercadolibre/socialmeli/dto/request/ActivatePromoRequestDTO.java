package ar.com.mercadolibre.socialmeli.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivatePromoRequestDTO {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("post_id")
    private Integer postId;
    private Double discount;
}
