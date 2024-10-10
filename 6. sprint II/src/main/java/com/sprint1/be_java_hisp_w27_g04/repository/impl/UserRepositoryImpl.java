package com.sprint1.be_java_hisp_w27_g04.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    List<User> listOfUsers;
    public UserRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        try {
            File file = ResourceUtils.getFile("classpath:users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
            listOfUsers = objectMapper.readValue(file, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Error loading character data: " + e.getMessage(), e);
        }
    }

    @Override
    public void save(User user) {
        listOfUsers.add(user);
    }

    @Override
    public List<User> findAll() {
        return listOfUsers;
    }

    @Override
    public Optional<User> findById(int id) {
        return listOfUsers.stream().filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public List<User> findAllFollowedInOrder(int userId, Optional<String> orderBy) {

        User user = findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Set<Integer> followed = user.getFollowed();
        Set<User> userList = findAll().stream()
                .filter(x->followed.contains(x.getId())).collect(Collectors.toSet());

        if (orderBy.isEmpty()) {
            return userList.stream()
                    .toList();
        }

        Comparator<User> comparator = UserComparator.valueOf(orderBy.get().toUpperCase(Locale.ROOT)).getComparator();
        return userList.stream()
                .sorted(comparator)
                .toList();
    }

    @Override
    public List<User> findAllFollowersInOrder(int userId, Optional<String> orderBy) {

        User user = findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Set<Integer> followers = user.getFollowers();
        Set<User> userList = findAll().stream()
                .filter(x->followers.contains(x.getId())).collect(Collectors.toSet());

        if (orderBy.isEmpty()) {
            return userList.stream()
                    .toList();
        }

        Comparator<User> comparator = UserComparator.valueOf(orderBy.get().toUpperCase(Locale.ROOT)).getComparator();
        return userList.stream()
                .sorted(comparator)
                .toList();
    }


}
