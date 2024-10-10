package com.sprint1.be_java_hisp_w27_g04.repository;

import com.sprint1.be_java_hisp_w27_g04.entity.Post;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    void save(Post post);
    List<Post> findAll();
    Optional<Post> findById(int id);
    void delete(Post post);
}
