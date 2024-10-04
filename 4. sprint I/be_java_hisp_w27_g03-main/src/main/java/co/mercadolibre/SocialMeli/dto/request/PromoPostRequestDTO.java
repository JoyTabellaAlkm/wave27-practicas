package co.mercadolibre.SocialMeli.dto.request;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import co.mercadolibre.SocialMeli.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostRequestDTO {
    @JsonProperty("user_id")
    private int userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private ProductDTO product;
    private int category;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
