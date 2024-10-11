package com.sprint1.be_java_hisp_w27_g04.listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w27_g04.entity.Post;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.repository.impl.PostRepositoryImpl;
import com.sprint1.be_java_hisp_w27_g04.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserRepositoryImpl userRepository;

    @Autowired
    private PostRepositoryImpl postRepositoryImpl;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<User> listOfUsers;

        try {
            File file = ResourceUtils.getFile("classpath:users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());

            // Registrar el módulo para manejar LocalDate

            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            listOfUsers = objectMapper.readValue(file, new TypeReference<List<User>>() {});

            listOfUsers.forEach(user -> userRepository.save(user));

            for( User users : listOfUsers ) {
                users.getPosts().forEach(
                        post -> {
                            post.setPostDate(LocalDate.now());
                            postRepositoryImpl.save(post);
                        }
                );
            }

        } catch (IOException e) {
            throw new RuntimeException("Error loading character data: " + e.getMessage(), e);
        }

    }
}
