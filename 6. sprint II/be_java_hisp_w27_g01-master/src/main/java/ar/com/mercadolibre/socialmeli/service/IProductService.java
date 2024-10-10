package ar.com.mercadolibre.socialmeli.service;


import ar.com.mercadolibre.socialmeli.dto.request.ActivatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.CreatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.PostRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.response.*;
import ar.com.mercadolibre.socialmeli.dto.response.FollowersListResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.PostDetailsResponseDTO;
import ar.com.mercadolibre.socialmeli.dto.response.PostOkResponseDTO;

import java.time.LocalDate;
import java.util.List;



public interface IProductService {

    PostOkResponseDTO createPost(PostRequestDTO postRequestDTO);

    CreatePromoResponseDTO createPromoPost(CreatePromoRequestDTO dto);

    FollowersListResponseDTO getRecentPostFromFollowedUsers(Integer userId, String order);

    ProductPromoCountResponseDTO getPromoProductsCountBySeller(Integer userId);

    List<PostDetailsResponseDTO> searchPostsByDate(LocalDate dateStart, LocalDate dateEnd);

    PostOkResponseDTO deletePost(Integer userId, Integer postId);

    List<SearchResponseDTO> searchPostByBrandAndName(String query, Integer userId);

    ProductPostsHistoryResponseDTO getSellerPostListHistory(Integer userId, Boolean withPromo);

    PostOkResponseDTO activatePromo(ActivatePromoRequestDTO promo);
}

