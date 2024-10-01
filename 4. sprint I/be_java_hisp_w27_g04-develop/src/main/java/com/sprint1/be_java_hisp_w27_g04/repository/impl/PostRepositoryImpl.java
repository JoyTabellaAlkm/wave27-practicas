package com.sprint1.be_java_hisp_w27_g04.repository.impl;

import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    List<Post> postList;

    public PostRepositoryImpl() throws IOException {
        postList = new LinkedList<>();
    }

    /*@Override
    public void save(Post post) {
        int newId = postList.size();
        post.setPostId(newId);
        postList.add(post);
    }*/

    @Override
    public void save(Post post) {

        int newId = postList.size();
        post.setPostId(newId);
        postList.add(post);
    }


    @Override
    public List<Post> findAll() {
        return postList;
    }

    @Override
    public Optional<Post> findById(int id) {
        return postList.stream().filter(post -> post.getPostId() == id).findFirst();
    }

    @Override
    public void delete(Post post) {
        postList.remove(post);
    }

}
