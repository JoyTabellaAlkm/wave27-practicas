package com.ar.mercadolibre.blogexception.repository;

import com.ar.mercadolibre.blogexception.dto.BlogDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository {
    private Map<Integer, BlogDTO> blogList = new HashMap<>();

    public BlogRepository () {
        LocalDate today = LocalDate.now();
        //blogList.put(1, new BlogDTO(1, "Harry Potter", "Angela", today));
    }

    public int createBlog(BlogDTO blog) {
        int blogId = blog.getId();
        blogList.put(blogId, blog);

        return blogId;
    }

    public BlogDTO findBlogById(int id) {
        return blogList.get(id);
    }

    public Map<Integer, BlogDTO> findAll() {
        return blogList;
    }
}
