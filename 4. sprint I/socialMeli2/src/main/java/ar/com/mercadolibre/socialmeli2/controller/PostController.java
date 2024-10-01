package ar.com.mercadolibre.socialmeli2.controller;

import ar.com.mercadolibre.socialmeli2.dto.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.PromoPostDto;
import ar.com.mercadolibre.socialmeli2.service.IPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.addPost(postDto));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsFromFollowed(@PathVariable int userId, @RequestParam(required = false) String order) {
        return ResponseEntity.ok(postService.getPostsFromFollowed(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@RequestBody PromoPostDto promoPostDto) {
        return ResponseEntity.ok(postService.addPromoPost(promoPostDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam int userId) {
        return ResponseEntity.ok(postService.getPromoPostCount(userId));
    }
}
