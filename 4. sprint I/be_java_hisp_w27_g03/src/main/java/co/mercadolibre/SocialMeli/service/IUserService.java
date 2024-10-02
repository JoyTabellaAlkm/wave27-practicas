package co.mercadolibre.SocialMeli.service;

import co.mercadolibre.SocialMeli.dto.response.ClientFollowedDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;

import java.util.List;

public interface IUserService {

    ResponseDTO followSeller(int userId, int userIdToFollow);

    ClientFollowedDTO listFollowedSellers(int userId, String order);

    ResponseDTO unfollow(int userId, int userIdToUnfollow);

}
