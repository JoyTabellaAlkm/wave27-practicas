package com.sprint1.be_java_hisp_w27_g04.service;

import com.sprint1.be_java_hisp_w27_g04.dto.response.*;
import com.sprint1.be_java_hisp_w27_g04.entity.User;
import java.util.List;


public interface IUsersService {
    ResponseFollowersDTO getFollowers(int userId,String order);
    UserFollowersCountResponseDTO getUserFollowersCountById(int userId);
    ResponseFollowedDTO getFollowed(int userId, String order);
    ResponseDTO followSeller(int userId, int userIdToFollow);
    ResponseDTO unfollowSeller(int userId, int userIdToUnfollow);
    List<User> getAll();
    List<ResponsePostDTO> getSellerPosts(int userId);
}
