package co.mercadolibre.SocialMeli.service;

import co.mercadolibre.SocialMeli.dto.request.PostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.RecentPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;

public interface IPostService {
    ResponseDTO createPost(PostRequestDTO post);
    RecentPostDTO getPostsByFollowedUsersLastTwoWeeks(int userId, String order);
}
