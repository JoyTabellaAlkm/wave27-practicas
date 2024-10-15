package ar.com.mercadolibre.socialmeli2.repository.impl;

import ar.com.mercadolibre.socialmeli2.entity.Post;
import ar.com.mercadolibre.socialmeli2.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    HashMap<Integer, Post> posts;

    public PostRepositoryImpl() {
        posts = new HashMap<>();
    }

    @Override
    public boolean save(Post post) {
        int id = post.getId();
        posts.put(id, post);
        return posts.containsKey(id);
    }

    @Override
    public int nextId() {
        return posts.size() + 1;
    }

    @Override
    public List<Post> findByUserId(int userId) {
        return posts.values().stream()
                .filter(post -> post.getUser().getId() == userId)
                .toList();
    }
}
