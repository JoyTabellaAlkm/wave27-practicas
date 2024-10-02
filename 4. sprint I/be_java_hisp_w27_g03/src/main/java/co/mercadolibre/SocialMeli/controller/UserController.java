package co.mercadolibre.SocialMeli.controller;

import co.mercadolibre.SocialMeli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(iUserService.followSeller(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public  ResponseEntity<?> listFollowedSellers(@PathVariable int userId, @RequestParam (required =false) String order ){
        return new ResponseEntity<>(iUserService.listFollowedSellers(userId,order), HttpStatus.OK);
    }


    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollow(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(iUserService.unfollow(userId,userIdToUnfollow), HttpStatus.OK);
    }
}
