package co.mercadolibre.SocialMeli.controller;

import co.mercadolibre.SocialMeli.service.ISellerService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@Validated
public class SellerController {
    @Autowired
    ISellerService sellerService;

    @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<?> countFollowers(@PathVariable @Positive(message = "El id debe ser positivo") int userId){
        return new ResponseEntity<>(sellerService.countFollowers(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<?> listFollowers(@PathVariable @Positive(message = "El id debe ser positivo") int userId, @RequestParam(required = false)  String order){
        return new ResponseEntity<>(sellerService.listFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/list/most_active_sellers")
    public ResponseEntity<?> listMostActiveSellers(){
        return new ResponseEntity<>(sellerService.listMostActiveSellers(), HttpStatus.OK);
    }

    @GetMapping("/users/list/inactive_sellers")
    public ResponseEntity<?> inactiveSellers(){
        return new ResponseEntity<>(sellerService.inactiveSeller(), HttpStatus.OK);
    }

}
