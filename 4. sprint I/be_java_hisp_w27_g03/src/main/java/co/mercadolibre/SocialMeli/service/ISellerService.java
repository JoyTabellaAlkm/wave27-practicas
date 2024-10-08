package co.mercadolibre.SocialMeli.service;

import co.mercadolibre.SocialMeli.dto.response.CountFollowersDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPostDTO;
import co.mercadolibre.SocialMeli.dto.response.SellerFollowersDTO;
import co.mercadolibre.SocialMeli.dto.response.SellerLastPostDTO;

import java.util.List;

public interface ISellerService {
    CountFollowersDTO countFollowers(int userId);
    SellerFollowersDTO listFollowers(int userId, String order);
    List<SellerLastPostDTO> inactiveSeller();
    List<CountPostDTO> listMostActiveSellers();
}
