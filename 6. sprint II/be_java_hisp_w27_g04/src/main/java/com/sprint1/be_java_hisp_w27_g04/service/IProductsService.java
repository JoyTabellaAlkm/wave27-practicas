package com.sprint1.be_java_hisp_w27_g04.service;

import com.sprint1.be_java_hisp_w27_g04.dto.PostDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;

import com.sprint1.be_java_hisp_w27_g04.dto.PostListDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.PostNoPromoDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ListOfPostsWithPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.QuantityOfPostsWithPromotionDTO;

import java.util.List;

public interface IProductsService {
    void newPost(PostRequestDTO dto);
    ResponseDTO createPostWithPromotion(PostPromotionDTO postPromotionDTO);
    QuantityOfPostsWithPromotionDTO countAllPostWithPromoFromUser(Integer userId);
    ListOfPostsWithPromotionDTO getAllPostWithPromoFromUser(Integer userId);
    PostListDTO getPostList(int userId, String order);
    PostDTO applyDiscountToPost(Integer postId, Double discount);
    ResponseDTO deletePost(int postId);
    List<PostPromotionDTO> getPostsByPrices(int minPrice, int maxPrice);
    PostNoPromoDTO finishPromotion(int postId);

}
