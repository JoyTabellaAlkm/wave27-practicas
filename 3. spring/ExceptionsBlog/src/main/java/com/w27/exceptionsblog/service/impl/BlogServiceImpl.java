package com.w27.exceptionsblog.service.impl;

import com.w27.exceptionsblog.dto.BlogPostDTO;
import com.w27.exceptionsblog.exceptions.BlogPostNotFoundException;
import com.w27.exceptionsblog.model.BlogPost;
import com.w27.exceptionsblog.repository.IBlogRepository;
import com.w27.exceptionsblog.service.IBlogService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    public List<BlogPostDTO> getAll() {
        List<BlogPost> blogPostsList = blogRepository.getAll();
        List<BlogPostDTO> blogPostDTOList = new ArrayList<>();

        for (BlogPost post : blogPostsList) {
            BlogPostDTO postDTO = new BlogPostDTO(post.getId(), post.getTitle(), post.getAuthorName(), post.getDate());
            blogPostDTOList.add(postDTO);
        }
        return blogPostDTOList;
    }

    public BlogPostDTO findById(Integer id) {
        BlogPost entry = blogRepository.findById(id);
        if (entry == null){
            throw new BlogPostNotFoundException("No existe un post con ese id");
        }
        return new BlogPostDTO(entry.getId(), entry.getTitle(), entry.getAuthorName(), entry.getDate());
    }

    @Override
    public Integer newPost(BlogPostDTO post) {
        BlogPost blogPost = new BlogPost(post.getId(), post.getTitle(), post.getAuthorName(), LocalDateTime.now());
        return blogRepository.save(blogPost);//devuelve el id del post
    }

}