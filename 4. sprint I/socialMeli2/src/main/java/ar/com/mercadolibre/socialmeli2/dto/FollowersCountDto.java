package ar.com.mercadolibre.socialmeli2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowersCountDto {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String username;
    @JsonProperty("followers_count")
    private int followersCount;
}
