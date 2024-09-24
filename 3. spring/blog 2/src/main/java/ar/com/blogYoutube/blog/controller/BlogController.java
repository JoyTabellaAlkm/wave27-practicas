package ar.com.blogYoutube.blog.controller;

import ar.com.blogYoutube.blog.dto.EntradaBlogResponseDTO;
import ar.com.blogYoutube.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntradaBlog(@RequestBody EntradaBlogResponseDTO entradaBlogResponseDTO) {
        return ResponseEntity.ok().body(blogService.agregarBlog(entradaBlogResponseDTO));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> listarEntradaBlog() {
        return ResponseEntity.ok().body(blogService.obtenerEntradaBlogs());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(blogService.obtenerEntradaBlogporId(id));
    }
}
