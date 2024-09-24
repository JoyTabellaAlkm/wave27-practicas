package com.w27.exceptionsblog.service;
import com.w27.exceptionsblog.dto.BlogPostDTO;
import java.util.List;

public interface IBlogService {
    public List<BlogPostDTO> getAll();
    public BlogPostDTO findById(Integer id);
    public Integer newPost(BlogPostDTO post);
}
