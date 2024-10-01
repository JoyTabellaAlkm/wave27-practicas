package ar.com.mercadolibre.socialmeli.controller;

import ar.com.mercadolibre.socialmeli.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowerList(@PathVariable Integer userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(userService.getFollowerList(userId, order), HttpStatus.OK);
    }

    @GetMapping("{userId}/followed/list")
    public ResponseEntity<?> getFollowedList(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(userService.findByFollowed(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getFollowerCount(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followASpecificUserById(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(userService.followASpecificUserById(userId, userIdToFollow), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowASpecificUserById(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow){
        return new ResponseEntity<>(userService.unfollowASpecificUserById(userId, userIdToUnfollow), HttpStatus.OK);
    }
}
