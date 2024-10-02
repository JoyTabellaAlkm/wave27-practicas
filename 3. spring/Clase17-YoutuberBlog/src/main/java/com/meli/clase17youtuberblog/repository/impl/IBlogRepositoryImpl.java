package com.meli.clase17youtuberblog.repository.impl;

import com.meli.clase17youtuberblog.dto.BlogDTO;
import com.meli.clase17youtuberblog.exception.ExistingBlogException;
import com.meli.clase17youtuberblog.exception.NonExistingBlogException;
import com.meli.clase17youtuberblog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class IBlogRepositoryImpl implements IBlogRepository {
    private Map<String, BlogDTO> blogs = new HashMap<>();

    public IBlogRepositoryImpl() {
        blogs.put("1", new BlogDTO("1", "Blog 1", "Vanessa", LocalDate.of(2024, Month.of(9), 23)));
        blogs.put("2", new BlogDTO("2", "Blog 2", "Maria", LocalDate.of(2024, Month.of(9), 13)));
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        return blogs.values().stream().toList();
    }

    @Override
    public BlogDTO getBlog(String id) throws NonExistingBlogException {
        if (!blogs.containsKey(id)) {
            throw new NonExistingBlogException(id);
        }
        return blogs.get(id);
    }

    @Override
    public BlogDTO newBlog(BlogDTO blogDTO) throws ExistingBlogException{
        if (blogs.containsKey(blogDTO.getId())) {
            throw new ExistingBlogException(blogDTO.getId());
        }
        blogs.put(blogDTO.getId(), blogDTO);
        return blogs.get(blogDTO.getId());
    }
}
