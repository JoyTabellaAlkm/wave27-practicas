package co.mercadolibre.SocialMeli.dto.request;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostRequestDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("product")
    private ProductDTO product;
    private int category;
    private double price;
}
