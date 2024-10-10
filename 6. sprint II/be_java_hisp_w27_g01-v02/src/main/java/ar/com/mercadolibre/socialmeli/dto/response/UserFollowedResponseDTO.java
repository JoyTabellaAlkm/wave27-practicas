package ar.com.mercadolibre.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedResponseDTO {
    private Integer userId;
    private String userName;
    private List<UserNameResponseDTO> followed;
}
