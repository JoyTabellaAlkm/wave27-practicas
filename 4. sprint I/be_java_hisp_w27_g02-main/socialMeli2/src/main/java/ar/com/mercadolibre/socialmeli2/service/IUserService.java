package ar.com.mercadolibre.socialmeli2.service;

import ar.com.mercadolibre.socialmeli2.dto.*;

import java.util.List;

public interface IUserService {
    FollowDto followUser(int userId, int userIdToFollow);

    FollowersCountDto countFollowers(int userId);

    UserFollowedDto findAllFollowed(int userId, String order);

    UserWithFollowersDto findAllFollowers(int userId, String order);

    List<Top10UserDto> findTop10Users();

    FollowDto unfollowUser(int userId, int userIdToUnfollow);
}
