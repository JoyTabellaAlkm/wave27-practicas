package co.mercadolibre.SocialMeli.dto.response;

import co.mercadolibre.SocialMeli.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecentPostDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("posts")
    private List<PostResponseDTO> recentPosts;


}
