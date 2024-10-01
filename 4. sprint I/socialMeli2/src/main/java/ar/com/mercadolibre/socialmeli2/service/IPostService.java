package ar.com.mercadolibre.socialmeli2.service;

import ar.com.mercadolibre.socialmeli2.dto.PromoCountDto;
import ar.com.mercadolibre.socialmeli2.dto.UserFollowedPostsDto;
import ar.com.mercadolibre.socialmeli2.dto.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.PromoPostDto;


public interface IPostService {
    PostDto addPost(PostDto postDto);
    UserFollowedPostsDto getPostsFromFollowed(int userId, String order);

    PromoPostDto addPromoPost(PromoPostDto promoPostDto);
    PromoCountDto getPromoPostCount(int userId);
}
