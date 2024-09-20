package ar.org.mercadolibre.ejercicioblog.repository;

import ar.org.mercadolibre.ejercicioblog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository {

    List<Blog> blogs = new ArrayList<>();

    public BlogRepository() {
        blogs.add(new Blog(1,"Primero","Sebastian","12 de junio de 2024"));
        blogs.add(new Blog(1,"Segundo","Sofia","3 de julio de 2024"));
        blogs.add(new Blog(1,"Tercero","Emilia","5 de septiembre de 2024"));


    }
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
