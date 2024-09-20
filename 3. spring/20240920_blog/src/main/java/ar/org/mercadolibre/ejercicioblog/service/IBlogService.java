package ar.org.mercadolibre.ejercicioblog.service;

import ar.org.mercadolibre.ejercicioblog.dto.BlogDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBlogService {

    String createBlog(BlogDto blog);

    List<BlogDto> findAll();

    BlogDto findById( int id);


}
