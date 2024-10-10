package ar.com.mercadolibre.socialmeli.repository.impl;

import ar.com.mercadolibre.socialmeli.entity.Post;
import ar.com.mercadolibre.socialmeli.entity.User;
import ar.com.mercadolibre.socialmeli.repository.IRepository;
import ar.com.mercadolibre.socialmeli.utils.Utils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryImpl implements IRepository {
    private final List<User> users;

    public RepositoryImpl(){
        users = Utils.createDefaultUsers();
    }

    @Override
    public Integer createPost(User user, Post post) {
        Integer createdId = user.getPosts().stream().mapToInt(Post::getPostId).max().orElse(0) + 1;
        post.setPostId(createdId);

        user.addToPosts(post);

        users.replaceAll(u -> u.getUserId().equals(user.getUserId()) ? user : u);
        return createdId;
    }

    @Override
    public User getUserById(Integer id) {
        return users.stream().filter(u -> u.getUserId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return this.users;
    }

    @Override
    public Boolean existId(Integer userId){
        return this.users.stream()
                .anyMatch(user -> user.getUserId().equals(userId));
    }

    @Override
    public Boolean addPostToUser(User user, Post post) {
        return user.addToPosts(post);
    }

    @Override
    public Boolean updateUser(User user) {
        Optional<User> existingUserOpt = users.stream()
                .filter(u -> u.getUserId().equals(user.getUserId()))
                .findFirst();

        if (existingUserOpt.isPresent()) {
            int index = users.indexOf(existingUserOpt.get());
            users.set(index, user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean removePost(Post post){
        return users.stream().anyMatch(user -> user.getPosts().remove(post));
    }

    public void updatePost(User user, Post post) {
        users.stream()
                .filter(u -> u.getUserId().equals(user.getUserId()))
                .findFirst()
                .ifPresent(u -> {
                    u.getPosts().stream()
                            .filter(p -> p.getPostId().equals(post.getPostId()))
                            .findFirst()
                            .ifPresent(existingPost -> {
                                int postIndex = u.getPosts().indexOf(existingPost);
                                u.getPosts().set(postIndex, post);
                            });
                    int userIndex = users.indexOf(u);
                    users.set(userIndex, u);
                });
    }
}