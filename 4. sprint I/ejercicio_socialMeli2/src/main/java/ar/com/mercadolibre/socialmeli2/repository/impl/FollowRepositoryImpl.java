package ar.com.mercadolibre.socialmeli2.repository.impl;

import ar.com.mercadolibre.socialmeli2.entity.Follow;
import ar.com.mercadolibre.socialmeli2.repository.IFollowRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class FollowRepositoryImpl implements IFollowRepository {
    private final Set<Follow> follows;

    public FollowRepositoryImpl() {
        this.follows = new HashSet<>();
    }

    @Override
    public boolean save(Follow follow) {
        follows.add(follow);
        return follows.contains(follow);
    }

    @Override
    public List<Follow> findFollowsByFollowerId(int userId) {
        return follows.stream()
                .filter(follow -> follow.getUser().getId() == userId)
                .toList();
    }

    @Override
    public List<Follow> findFollowsByFollowedId(int userId) {
        return follows.stream()
                .filter(follow -> follow.getUserToFollow().getId() == userId)
                .toList();
    }

    @Override
    public boolean unfollowUser(Follow follow) {
        return follows.remove(follow);
    }

    @Override
    public boolean isFollowing(int userId, int userIdFollowed) {
        return follows.stream()
                .anyMatch(follow -> follow.getUser().getId() == userId && follow.getUserToFollow().getId() == userIdFollowed);
    }
}
