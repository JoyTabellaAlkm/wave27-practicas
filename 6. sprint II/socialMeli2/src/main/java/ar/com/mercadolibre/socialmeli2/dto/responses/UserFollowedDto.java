package ar.com.mercadolibre.socialmeli2.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class UserFollowedDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String username;
    private List<UserDto> followed;
}
