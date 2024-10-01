package ar.com.mercadolibre.socialmeli2.controller;

import ar.com.mercadolibre.socialmeli2.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService usersService) {
        this.userService = usersService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable int userId) {
        return ResponseEntity.ok(userService.countFollowers(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> findAllFollowed(@PathVariable int userId, @RequestParam (required = false) String order) {
        return ResponseEntity.ok(userService.findAllFollowed(userId, order));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> findAllFollowers(@PathVariable int userId, @RequestParam (required = false) String order) {
        return ResponseEntity.ok(userService.findAllFollowers(userId, order));
    }

    @GetMapping("/top-10")
    public ResponseEntity<?> findTop10Users() {
        return ResponseEntity.ok(userService.findTop10Users());
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }
}
