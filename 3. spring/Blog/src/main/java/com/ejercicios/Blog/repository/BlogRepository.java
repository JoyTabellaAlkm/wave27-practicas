package com.ejercicios.Blog.repository;

import com.ejercicios.Blog.dto.BlogDTO;
import com.ejercicios.Blog.entity.Blog;
import com.ejercicios.Blog.exception.BlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    List<Blog> blogs = new ArrayList<>();

    public Blog save(Blog blog){
        blogs.add(blog);
        return blog;
    }

    public List<Blog> findAll(){
        return blogs;
    }
    public Blog findById(int id){
        return blogs.stream().filter(blog -> blog.getId() == id).findFirst().orElse(null);
    }
}
