package com.sprint1.be_java_hisp_w27_g04.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    List<Post> postList;
    private Integer actualId = 100;

    public PostRepositoryImpl() throws IOException {
        postList = new LinkedList<>();
        loadDataBase();
    }

    private void loadDataBase() throws IOException {

        try {
            File file = ResourceUtils.getFile("classpath:posts.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

            // Registrar el módulo para manejar LocalDate

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            postList = objectMapper.readValue(file, new TypeReference<List<Post>>() {
            });
            postList.forEach(
                    post -> {
                        if (post.getPostId() == 1) {
                            post.setPostDate(LocalDate.now());
                        }
                    }
            );


        } catch (IOException e) {
            throw new RuntimeException("Error loading character data: " + e.getMessage(), e);
        }
    }

    @Override
    public void save(Post post) {
        int newId = actualId;
        post.setPostId(newId);
        postList.add(post);
        actualId++;
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
