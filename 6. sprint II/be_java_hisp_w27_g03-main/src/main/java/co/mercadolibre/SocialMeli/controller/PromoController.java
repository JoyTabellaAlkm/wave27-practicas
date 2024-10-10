package co.mercadolibre.SocialMeli.controller;

import co.mercadolibre.SocialMeli.dto.request.PromoPostRequestDTO;
import co.mercadolibre.SocialMeli.service.IPromoPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Validated
public class PromoController {
    @Autowired
    IPromoPostService iPromoPostService;

    @PostMapping("/promo-post")
    public ResponseEntity<?> publicPromoPost(@RequestBody @Valid PromoPostRequestDTO promoPostRequestDTO){
        return new ResponseEntity<>(iPromoPostService.postPromotion(promoPostRequestDTO), HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countPromoPostUser(@RequestParam @Positive(message = "El id debe ser positivo") int userId){
        return new ResponseEntity<>(iPromoPostService.countPromoPostUser(userId), HttpStatus.OK);
    }
}
