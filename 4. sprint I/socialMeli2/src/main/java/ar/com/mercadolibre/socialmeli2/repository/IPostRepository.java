package ar.com.mercadolibre.socialmeli2.repository;

import ar.com.mercadolibre.socialmeli2.entity.Post;

import java.util.List;

public interface IPostRepository {
    boolean save(Post post);

    int nextId();

    List<Post> findByUserId(int userId);
}
