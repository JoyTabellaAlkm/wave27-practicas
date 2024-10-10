package ar.com.mercadolibre.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("followed_ids")
    private List<Integer> followedIds = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public User(Integer userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public void addFollowedId(Integer followedId) {
        this.followedIds.add(followedId);
    }

    public Boolean addToPosts(Post post) {
        return this.posts.add(post);
    }

    public void removeFollowedId(Integer followedId) {
        this.followedIds.remove(followedId);
    }
}
