package ar.com.mercadolibre.socialmeli2.repository.impl;


import ar.com.mercadolibre.socialmeli2.entity.User;
import ar.com.mercadolibre.socialmeli2.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final Map<Integer, User> users;

    public UserRepositoryImpl() {
        this.users = new HashMap<>();
        generateUsers();
    }

    @Override
    public boolean save(User user) {
        users.put(user.getId(), user);
        return users.containsKey(user.getId());
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public boolean existsById(int userId) {
        return users.containsKey(userId);
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }

    private void generateUsers() {
        User user1 = new User(1, "Pepe");
        User user2 = new User(2, "Juan");
        User user3 = new User(3, "Jose");
        User user4 = new User(4, "Oscar");
        User user5 = new User(5, "Hernan");
        User user6 = new User(6, "Santiago");

        save(user1);
        save(user2);
        save(user3);
        save(user4);
        save(user5);
        save(user6);
    }
}
