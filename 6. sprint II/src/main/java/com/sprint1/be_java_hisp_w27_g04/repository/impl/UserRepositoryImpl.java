package com.sprint1.be_java_hisp_w27_g04.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import com.sprint1.be_java_hisp_w27_g04.exceptions.NotFoundException;
import com.sprint1.be_java_hisp_w27_g04.repository.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    List<User> listOfUsers = new LinkedList<>();
    public UserRepositoryImpl() throws IOException {
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
