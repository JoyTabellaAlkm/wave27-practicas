package ar.com.mercadolibre.blog.controller;

import ar.com.mercadolibre.blog.dto.CreateBlogDto;
import ar.com.mercadolibre.blog.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBlogDto createBlogDto) {
        Integer id = blogService.create(createBlogDto);
        return ResponseEntity.ok("El blog %d se ha creado correctamente.".formatted(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(blogService.getAll());
    }
}
