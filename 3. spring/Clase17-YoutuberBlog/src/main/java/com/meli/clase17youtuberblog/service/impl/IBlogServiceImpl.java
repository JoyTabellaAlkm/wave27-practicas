package com.meli.clase17youtuberblog.service.impl;

import com.meli.clase17youtuberblog.dto.BlogDTO;
import com.meli.clase17youtuberblog.exception.ExistingBlogException;
import com.meli.clase17youtuberblog.exception.NonExistingBlogException;
import com.meli.clase17youtuberblog.repository.IBlogRepository;
import com.meli.clase17youtuberblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public BlogDTO newBlog(BlogDTO blogDTO) throws ExistingBlogException {
        return blogRepository.newBlog(blogDTO);
    }

    @Override
    public BlogDTO getBlog(String id) throws NonExistingBlogException {
        return blogRepository.getBlog(id);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }
}
