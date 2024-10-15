package ar.com.mercadolibre.socialmeli2.service;

import ar.com.mercadolibre.socialmeli2.dto.responses.PromoCountDto;
import ar.com.mercadolibre.socialmeli2.dto.responses.UserFollowedPostsDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.PromoPostDto;


public interface IPostService {
    PostDto addPost(PostDto postDto);
    UserFollowedPostsDto getPostsFromFollowed(int userId, String order);

    PromoPostDto addPromoPost(PromoPostDto promoPostDto);
    PromoCountDto getPromoPostCount(int userId);
}
