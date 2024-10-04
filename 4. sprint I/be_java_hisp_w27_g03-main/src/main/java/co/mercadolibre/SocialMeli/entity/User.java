package co.mercadolibre.SocialMeli.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonIgnore
    private List<User> followers; //lista de seguidores
    @JsonIgnore
    private List<User> followed; // listas de seguidos
    @JsonIgnore
    private List<Post> posts;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        //inicializar las listas
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

}