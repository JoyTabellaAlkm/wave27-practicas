package com.sprint1.be_java_hisp_w27_g04.controller;

import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.PostDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponsePostDiscountDTO;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductsService productsService;

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromotion(@RequestBody PostPromotionDTO postPromotionDTO){
        return new ResponseEntity<>(productsService.createPostWithPromotion(postPromotionDTO), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countAllPostWithPromoFromUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(productsService.countAllPostWithPromoFromUser(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListOfPostsWithPromoFromUser(@RequestParam Integer user_id){
        return new ResponseEntity<>(productsService.getAllPostWithPromoFromUser(user_id), HttpStatus.OK);
    }

    @PatchMapping("/promo-post/{postId}/end")
    public ResponseEntity<?> finishPromotion(@PathVariable Integer postId){
        productsService.finishPromotion(postId);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody PostRequestDTO post){
        productsService.newPost(post);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getAllPostFollowed(@PathVariable int userId,
                                                @Nullable @RequestParam (required = false) String order) {
        return new ResponseEntity<>(productsService.getPostList(userId, order), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId) {
        return new ResponseEntity<>(productsService.deletePost(postId), HttpStatus.OK);
    }

    @PutMapping("{postId}/discount")
    public ResponseEntity<?> applyDiscount(
            @PathVariable Integer postId,
            @RequestParam Double discount) {
        PostDTO updatedPostDTO = productsService.applyDiscountToPost(postId, discount);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponsePostDiscountDTO("Descuento aplicado exitosamente.", HttpStatus.OK.value(), updatedPostDTO));
    }
    @GetMapping("/prices")
    public ResponseEntity<?> getPostsByPrices(@RequestParam int since, @RequestParam int to){
        return new ResponseEntity<>(productsService.getPostsByPrices(since, to), HttpStatus.OK);
    }

}
