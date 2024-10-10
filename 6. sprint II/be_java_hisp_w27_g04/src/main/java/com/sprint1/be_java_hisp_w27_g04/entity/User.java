package com.sprint1.be_java_hisp_w27_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private Set<Integer> followers;
    private Set<Integer> followed;
    private Set<Post> posts;

    public Boolean addPost(Post post){

        return posts.add(post);
    }
    public Boolean addFollowed(User user){
        return followed.add(user.getId());
    }
    public Boolean addFollower(User user) {
        return followers.add(user.getId());
    }

    public Boolean deleteFollowed(User userToUnFollow) {
        return followed.remove(userToUnFollow.getId());
    }

    public Boolean deleteFollower(User user){
        return followers.remove(user.getId());
    }
}
