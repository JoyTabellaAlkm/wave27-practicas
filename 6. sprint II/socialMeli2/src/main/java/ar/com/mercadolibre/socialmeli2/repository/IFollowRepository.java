package ar.com.mercadolibre.socialmeli2.repository;

import ar.com.mercadolibre.socialmeli2.entity.Follow;

import java.util.List;

public interface IFollowRepository {
    boolean save(Follow follow);

    List<Follow> findFollowsByFollowerId(int userId);

    List<Follow> findFollowsByFollowedId(int userId);

    boolean unfollowUser(Follow follow);

    boolean isFollowing(int userId, int userIdFollowed);
}
