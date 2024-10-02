package co.mercadolibre.SocialMeli.controller;

import co.mercadolibre.SocialMeli.dto.request.PostRequestDTO;
import co.mercadolibre.SocialMeli.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO post){
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostByUserLastTwoWeeks(@PathVariable int userId, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getPostsByFollowedUsersLastTwoWeeks(userId,order), HttpStatus.OK);
    }

}
