package co.mercadolibre.SocialMeli.dto.request;

import co.mercadolibre.SocialMeli.dto.ProductDTO;
import co.mercadolibre.SocialMeli.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @NotNull(message = "El id no puede estar vacio.")
    @Min(value = 1, message = "El id debe ser mayor a cero")
    private Integer userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @NotNull(message = "El campo no puede estar vacío.")
    @PastOrPresent(message = "No se puede colocar una fecha futura.")
    private LocalDate date;

    @Valid
    @NotNull(message = "El campo no puede estar vacío.")
    private ProductDTO product;

    @NotNull(message = "El campo no puede estar vacio.")
    private Integer category;

    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 1, message = "El precio minimo por producto es de 1")
    @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
    private Double price;


    @JsonProperty("has_promo")
    @NotNull(message = "El campo no puede estar vacío.")
    private Boolean hasPromo;

    @NotNull(message = "El campo no puede estar vacío.")
    @Min(value = 0, message = "El descuento debe ser un valor entre 0 y 1")
    @Max(value = 1, message = "El descuento debe ser un valor entre 0 y 1")
    private Double discount;
}
