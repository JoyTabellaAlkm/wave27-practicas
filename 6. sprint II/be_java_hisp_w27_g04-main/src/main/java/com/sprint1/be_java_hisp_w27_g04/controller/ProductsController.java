package com.sprint1.be_java_hisp_w27_g04.controller;

import com.sprint1.be_java_hisp_w27_g04.dto.request.PostPromotionDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.request.PostRequestDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.PostDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponsePostDiscountDTO;
import com.sprint1.be_java_hisp_w27_g04.service.IProductsService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class ProductsController {

    @Autowired
    IProductsService productsService;

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromotion(@RequestBody @Valid PostPromotionDTO postPromotionDTO){
        return new ResponseEntity<>(productsService.createPostWithPromotion(postPromotionDTO), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countAllPostWithPromoFromUser(
            @RequestParam @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            Integer user_id){
        return new ResponseEntity<>(productsService.countAllPostWithPromoFromUser(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getListOfPostsWithPromoFromUser(
            @RequestParam @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            Integer user_id){
        return new ResponseEntity<>(productsService.getAllPostWithPromoFromUser(user_id), HttpStatus.OK);
    }

    @PatchMapping("/promo-post/{postId}/end")
    public ResponseEntity<?> finishPromotion(
            @PathVariable @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            Integer postId){
        return new ResponseEntity<>(productsService.finishPromotion(postId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> newPost(@RequestBody @Valid PostRequestDTO post){
        productsService.newPost(post);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getAllPostFollowed(
            @PathVariable @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            int userId,
            @Nullable @RequestParam(required = false)
            @Pattern(regexp = "date_(asc|desc)", message = "El parámetro order debe ser 'date_asc' o 'date_desc")
            String order) {
        return new ResponseEntity<>(productsService.getPostList(userId, order), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(
            @PathVariable @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            int postId) {
        return new ResponseEntity<>(productsService.deletePost(postId), HttpStatus.OK);
    }

    @PutMapping("{postId}/discount")
    public ResponseEntity<?> applyDiscount(
            @PathVariable @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            Integer postId,
            @RequestParam Double discount) {
        PostDTO updatedPostDTO = productsService.applyDiscountToPost(postId, discount);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponsePostDiscountDTO("Descuento aplicado exitosamente.", HttpStatus.OK.value(), updatedPostDTO));
    }
    @GetMapping("/prices")
    public ResponseEntity<?> getPostsByPrices(
            @RequestParam @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            int since,
            @RequestParam @NotNull(message = "El id no puede estar vacio") @Positive(message = "El id debe ser mayor a cero")
            int to){
        return new ResponseEntity<>(productsService.getPostsByPrices(since, to), HttpStatus.OK);
    }

}
