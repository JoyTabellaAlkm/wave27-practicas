package ar.com.mercadolibre.socialmeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String username;
}

