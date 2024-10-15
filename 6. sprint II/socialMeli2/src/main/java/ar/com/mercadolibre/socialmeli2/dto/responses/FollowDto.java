package ar.com.mercadolibre.socialmeli2.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("followed_user_id")
    private Integer userIdToFollow;
}
