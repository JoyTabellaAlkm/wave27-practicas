package com.sprint1.be_java_hisp_w27_g04.repository;


import com.sprint1.be_java_hisp_w27_g04.entity.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);

    List<User> findAllFollowedInOrder(int userId, Optional<String> orderBy);

    List<User> findAllFollowersInOrder(int userId, Optional<String> orderBy);
}
