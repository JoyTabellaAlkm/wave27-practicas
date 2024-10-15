package ar.com.mercadolibre.socialmeli2.controller;

import ar.com.mercadolibre.socialmeli2.dto.requests.PostDto;
import ar.com.mercadolibre.socialmeli2.dto.requests.PromoPostDto;
import ar.com.mercadolibre.socialmeli2.service.IPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> addPost(@RequestBody @Valid PostDto postDto) {
        return ResponseEntity.ok(postService.addPost(postDto));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsFromFollowed(@PathVariable
                                                  @NotNull(message = "El id del usuario no puede estar vacio.")
                                                  @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                                  @RequestParam(required = false)
                                                  @Pattern(regexp = "date_asc|date_desc", message = "Valor inválido. Use 'date_asc' o 'date_desc'.") String order) {
        return ResponseEntity.ok(postService.getPostsFromFollowed(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@Valid @RequestBody PromoPostDto promoPostDto) {
        return ResponseEntity.ok(postService.addPromoPost(promoPostDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostCount(@RequestParam
                                                   @NotNull(message = "El id del usuario no puede estar vacio.")
                                                   @Positive(message = "El id debe ser mayor a cero.") Integer userId) {
        return ResponseEntity.ok(postService.getPromoPostCount(userId));
    }
}
