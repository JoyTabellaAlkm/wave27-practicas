package ar.com.mercadolibre.socialmeli.controller;

import ar.com.mercadolibre.socialmeli.dto.request.ActivatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.CreatePromoRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.request.PostRequestDTO;
import ar.com.mercadolibre.socialmeli.dto.response.CreatePromoResponseDTO;
import ar.com.mercadolibre.socialmeli.service.IProductService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO publicationDTO) {
        return new ResponseEntity<>(productService.createPost(publicationDTO), HttpStatus.OK);
    }

    @PostMapping("promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody() CreatePromoRequestDTO requestDto) {
        CreatePromoResponseDTO dto = productService.createPromoPost(requestDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getRecentPostFromFollowedUsers(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(productService.getRecentPostFromFollowedUsers(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoProductsCountBySeller(@RequestParam(required = true, name = "user_id") int userId) {
        return new ResponseEntity<>(productService.getPromoProductsCountBySeller(userId), HttpStatus.OK);
    }

    @GetMapping("/search/date")
    public ResponseEntity<?> searchPostsByDate(@RequestParam(name = "date_start", required = true)
                                                           @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                           LocalDate dateStart,
                                                       @RequestParam(name = "date_end", required = false)
                                                           @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                       LocalDate dateEnd) {
        return new ResponseEntity<>(productService.searchPostsByDate(dateStart, dateEnd), HttpStatus.OK);
    }

    @DeleteMapping("/post/{userId}/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer userId,@PathVariable Integer postId){
        return new ResponseEntity<>(productService.deletePost(userId, postId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPostByBrandAndName(@RequestParam String query, @RequestParam(required = false, name = "user_id") Integer userId){
        return new ResponseEntity<>(productService.searchPostByBrandAndName(query, userId), HttpStatus.OK);
    }
  
    @GetMapping("/promo-post/{userId}/history")
    public ResponseEntity<?> getSellerPostListHistory(@PathVariable Integer userId, @RequestParam(required = false, name = "with_promo") Boolean withPromo){
     return new ResponseEntity<>(productService.getSellerPostListHistory(userId, withPromo), HttpStatus.OK);
    }

    @PutMapping("/posts/activate-promo")
    public ResponseEntity<?> activatePromo(@RequestBody ActivatePromoRequestDTO requestDTO) {
        return new ResponseEntity<>(productService.activatePromo(requestDTO), HttpStatus.OK);
    }
}
