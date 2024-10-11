package co.mercadolibre.SocialMeli.service;

import co.mercadolibre.SocialMeli.dto.request.PromoPostRequestDTO;
import co.mercadolibre.SocialMeli.dto.response.CountPromoPostDTO;
import co.mercadolibre.SocialMeli.dto.response.ResponseDTO;

public interface IPromoPostService {
    ResponseDTO postPromotion(PromoPostRequestDTO promoPostRequestDTO);
    CountPromoPostDTO countPromoPostUser(int userId);
}
