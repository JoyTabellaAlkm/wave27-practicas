package co.mercadolibre.SocialMeli.controller;

import co.mercadolibre.SocialMeli.service.IUserService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable  @Positive(message = "El id del usuario debe ser positivo") int userId, @PathVariable @Positive(message = "El id del vendedor debe ser positivo") int userIdToFollow){
        return new ResponseEntity<>(iUserService.followSeller(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public  ResponseEntity<?> listFollowedSellers(@PathVariable @Positive(message = "El id debe ser positivo") int userId, @RequestParam (required =false)  String order ){
        return new ResponseEntity<>(iUserService.listFollowedSellers(userId,order), HttpStatus.OK);
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable  @Positive(message = "El id del usuario debe ser positivo") int userId, @PathVariable  @Positive(message = "El id del vendedor debe ser positivo") int userIdToUnfollow){
        return new ResponseEntity<>(iUserService.unfollow(userId,userIdToUnfollow), HttpStatus.OK);
    }
}
