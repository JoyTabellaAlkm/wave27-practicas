package com.meli.clase17youtuberblog.service;
import com.meli.clase17youtuberblog.dto.BlogDTO;
import com.meli.clase17youtuberblog.exception.ExistingBlogException;
import com.meli.clase17youtuberblog.exception.NonExistingBlogException;

import java.util.List;

public interface IBlogService {

    BlogDTO newBlog(BlogDTO blogDTO) throws ExistingBlogException;
    BlogDTO getBlog(String id) throws NonExistingBlogException;
    List<BlogDTO> getAllBlogs();
}
