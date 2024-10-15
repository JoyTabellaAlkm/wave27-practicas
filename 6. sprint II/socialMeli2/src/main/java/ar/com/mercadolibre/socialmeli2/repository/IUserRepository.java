package ar.com.mercadolibre.socialmeli2.repository;

import ar.com.mercadolibre.socialmeli2.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    boolean save(User user);

    Optional<User> findById(int userId);

    boolean existsById(int userId);

    List<User> findAll();
}
