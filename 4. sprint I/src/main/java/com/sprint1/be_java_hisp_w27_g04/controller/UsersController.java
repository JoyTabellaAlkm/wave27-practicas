package com.sprint1.be_java_hisp_w27_g04.controller;

import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseFollowedDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseFollowersDTO;
import com.sprint1.be_java_hisp_w27_g04.dto.response.ResponseUserDTO;
import com.sprint1.be_java_hisp_w27_g04.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<?> unfollowSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(usersService.unfollowSeller(userId,userIdToUnfollow),HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId,@PathVariable int userIdToFollow){
        return new ResponseEntity<>(usersService.followSeller(userId,userIdToFollow), HttpStatus.OK);
    }

    /* US-0003 y US-0008, Listado de usuarios que siguen a un determinado vendedor
     ordenados de manera ascendente o descenente segun parametro */
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<?> getFollowers(
            @PathVariable int userId,
            @RequestParam(required = false, defaultValue = "name_asc") String order) {
        ResponseFollowersDTO users = usersService.getFollowers(userId,order);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseUserDTO<>(users, HttpStatus.OK.value()));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<?> getUserFollowersCountById(@PathVariable int userId){
        return ResponseEntity.ok(usersService.getUserFollowersCountById(userId));
    }

    /* US-0004 y US-0008 , Listado de todos los vendedores a los cuales sigue un determinado usuario
    ordenados de manera ascendente o descenente segun parametro */

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<?> getFollowed(
            @PathVariable int userId,
            @RequestParam(required = false, defaultValue = "name_asc") String order) {
        ResponseFollowedDTO users = usersService.getFollowed(userId,order);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseUserDTO<>(users, HttpStatus.OK.value()));
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<?> getSellerPosts(@PathVariable int userId){
        return ResponseEntity.ok(usersService.getSellerPosts(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(usersService.getAll());
    }

}
