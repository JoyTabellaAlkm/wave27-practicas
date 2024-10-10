package ar.com.mercadolibre.socialmeli.controller;

import ar.com.mercadolibre.socialmeli.service.IUserService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowerList(@PathVariable @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                             @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowerList(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable @Positive(message = "El id debe ser mayor a cero. ")  Integer userId,
                                             @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.findByFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable
                                               @Positive(message = "El id debe ser mayor a cero.")Integer userId){
        return new ResponseEntity<>(userService.getFollowerCount(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followASpecificUserById(@Validated @PathVariable @Positive(message = "El id debe ser mayor a cero.")  Integer userId,
                                                                @PathVariable @Positive(message = "El id debe ser mayor a cero.")  Integer userIdToFollow){
        return new ResponseEntity<>(userService.followASpecificUserById(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowASpecificUserById(
            @PathVariable @Positive(message = "El id debe ser mayor a cero.") Integer userId,
            @PathVariable @Positive(message = "El id debe ser mayor a cero.") Integer userIdToUnfollow) {
        return new ResponseEntity<>(userService.unfollowASpecificUserById(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
