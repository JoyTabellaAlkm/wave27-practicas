package ar.com.mercadolibre.socialmeli2.controller;

import ar.com.mercadolibre.socialmeli2.service.IUserService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    private final IUserService userService;

    public UserController(IUserService usersService) {
        this.userService = usersService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followUser(@PathVariable
                                        @NotNull(message = "El id no puede estar vacio.")
                                        @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                        @PathVariable
                                        @NotNull(message = "El id no puede estar vacio.")
                                        @Positive(message = "El id debe ser mayor a cero.") Integer userIdToFollow) {
        return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getFollowersCount(@PathVariable
                                               @NotNull(message = "El id no puede estar vacio.")
                                               @Positive(message = "El id debe ser mayor a cero.") Integer userId) {
        return ResponseEntity.ok(userService.countFollowers(userId));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> findAllFollowed(@PathVariable
                                             @NotNull(message = "El id no puede estar vacio.")
                                             @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                             @RequestParam(required = false)
                                             @Pattern(regexp = "name_asc|name_desc", message = "Valor inválido. Use 'name_asc' o 'name_desc'.") String order) {
        return ResponseEntity.ok(userService.findAllFollowed(userId, order));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> findAllFollowers(@PathVariable
                                              @NotNull(message = "El id no puede estar vacio.")
                                              @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                              @RequestParam(required = false)
                                              @Pattern(regexp = "name_asc|name_desc", message = "Valor inválido. Use 'name_asc' o 'name_desc'.") String order) {
        return ResponseEntity.ok(userService.findAllFollowers(userId, order));
    }

    @GetMapping("/top-10")
    public ResponseEntity<?> findTop10Users() {
        return ResponseEntity.ok(userService.findTop10Users());
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowUser(@PathVariable
                                          @NotNull(message = "El id no puede estar vacio.")
                                          @Positive(message = "El id debe ser mayor a cero.") Integer userId,
                                          @PathVariable
                                          @NotNull(message = "El id no puede estar vacio.")
                                          @Positive(message = "El id debe ser mayor a cero.") Integer userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollowUser(userId, userIdToUnfollow));
    }
}
