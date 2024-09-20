package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.exceptions.BlogEntryDoesNotExistsException;
import com.mercadolibre.blog.model.BlogEntry;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class BlogEntryRepository {

    private static HashSet<BlogEntry> entradasBlog = new HashSet<>();;

    public static Boolean addEntradaBlog(BlogEntry entradaBlog){

        boolean notExists;

        notExists = entradasBlog.stream()
                .filter(blogEntry -> blogEntry.getId() == entradaBlog.getId())
                .toList().isEmpty();

        if(notExists){
            entradasBlog.add(entradaBlog);
        }

        return notExists;

    }

    public static BlogEntry getEntradaBlog(int id){
        try{
            return entradasBlog.stream()
                    .filter(entradaBlog -> entradaBlog.getId() == id)
                    .findFirst().get();
        } catch (RuntimeException e) {
            throw new BlogEntryDoesNotExistsException("No existe ninguna entrada de blog con ese id");
        }
    }

    public static Set<BlogEntry> getEntradasBlog(){
        return entradasBlog;
    }
}
