package com.w27.exceptionsblog.repository;


import com.w27.exceptionsblog.exceptions.IllegalIdException;
import com.w27.exceptionsblog.model.BlogPost;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository

public class BlogRepository implements IBlogRepository{

    HashMap<Integer, BlogPost> blogPosts = new HashMap<>();
    {
        blogPosts.put(1, new BlogPost(1, "Primera entrada!!", "Santiago",LocalDateTime.now()));
        blogPosts.put(2, new BlogPost(2, "Anda esto??", "Santiago", LocalDateTime.of(2024, 5, 1, 0, 0)));
        blogPosts.put(3, new BlogPost(3, "Que ande por favoor", "Santiago",LocalDateTime.of(2024, 5, 1, 0, 0)));
    }

    @Override
    public Integer save(BlogPost blogPost) {
        Integer id = blogPost.getId();
        if (blogPosts.containsKey(id) || id == null){
            throw new IllegalIdException("El id ya existe o se ingresó un id no válido");
        }
        this.blogPosts.put(blogPost.getId(), blogPost);
        return blogPost.getId();
    }

    @Override
    public BlogPost findById(Integer id) {
       return this.blogPosts.values().stream()
               .filter(blogPost -> Objects.equals(blogPost.getId(), id))
               .findFirst()
               .orElse(null);
    }

    @Override
    public List<BlogPost> getAll() {
        return this.blogPosts.values().stream().toList();
    }
}
