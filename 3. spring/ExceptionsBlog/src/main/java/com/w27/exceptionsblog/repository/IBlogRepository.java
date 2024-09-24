package com.w27.exceptionsblog.repository;

import com.w27.exceptionsblog.dto.BlogPostDTO;
import com.w27.exceptionsblog.model.BlogPost;

import java.util.List;
import java.util.Map;

public interface IBlogRepository {
    public Integer save(BlogPost blogPost);
    public BlogPost findById(Integer id);
    public List<BlogPost> getAll();
}
