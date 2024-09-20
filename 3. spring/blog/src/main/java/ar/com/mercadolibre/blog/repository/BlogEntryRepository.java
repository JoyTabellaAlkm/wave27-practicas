package ar.com.mercadolibre.blog.repository;


import ar.com.mercadolibre.blog.exception.BlogEntryAlreadyExistException;
import ar.com.mercadolibre.blog.exception.BlogEntryNotFoundException;
import ar.com.mercadolibre.blog.model.BlogEntry;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class BlogEntryRepository {

    List<BlogEntry> blogEntries = new ArrayList<>();

    public BlogEntryRepository(){
        loadBlogEntries();
    }

    public void loadBlogEntries(){
        this.blogEntries.add(new BlogEntry(1, "Primer Blog", "Carlos", "2024-06-01"));
        this.blogEntries.add(new BlogEntry(2, "Segundo Blog", "Mariany", "2023-06-01"));
        this.blogEntries.add(new BlogEntry(3, "Tercer Blog", "Mati", "2021-06-01"));
    }

    public void saveBlogEntry(BlogEntry entry){

        this.blogEntries.add(entry);

    }

    public Boolean idExist(Integer id){
        return this.blogEntries.stream()
                .anyMatch(entry -> entry.getId().equals(id));
    }

    public BlogEntry getBlogEntryById(Integer id){

        return this.blogEntries.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

}
