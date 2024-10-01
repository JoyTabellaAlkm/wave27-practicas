package ar.com.mercadolibre.socialmeli.service;

import ar.com.mercadolibre.socialmeli.dto.response.UserFollowedResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerCountResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserFollowerListResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.UserOkResponseDTO;

import java.util.List;

public interface IUserService {

    List<UserFollowedResponseDTO> findByFollowed(Integer userId, String order);

    UserFollowerCountResponseDTO getFollowerCount(Integer userId);

    UserFollowerListResponseDTO getFollowerList(Integer userId, String order);

    UserOkResponseDTO followASpecificUserById(Integer userId, Integer userIdToFollow);

    UserOkResponseDTO unfollowASpecificUserById(Integer userId, Integer userIdToUnfollow);

}
