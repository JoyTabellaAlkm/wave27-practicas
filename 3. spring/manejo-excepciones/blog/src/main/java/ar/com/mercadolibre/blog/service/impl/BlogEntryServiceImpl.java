package ar.com.mercadolibre.blog.service.impl;

import ar.com.mercadolibre.blog.exception.BlogEntryAlreadyExistException;
import ar.com.mercadolibre.blog.exception.BlogEntryNotFoundException;
import ar.com.mercadolibre.blog.model.BlogEntry;
import ar.com.mercadolibre.blog.repository.BlogEntryRepository;
import ar.com.mercadolibre.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogEntryServiceImpl implements IBlogEntryService {

    @Autowired
    BlogEntryRepository blogEntryRepository;


    public Integer saveBlogEntry(BlogEntry entry) {

        if (blogEntryRepository.idExist(entry.getId())){
            throw new BlogEntryAlreadyExistException(String.format("There is already a Blog Entry with ID = %d", entry.getId()));
        }

        blogEntryRepository.saveBlogEntry(entry);

        return entry.getId();
    }

    public BlogEntry getBlogEntryById(Integer id){

        Boolean idExist = blogEntryRepository.idExist(id);

        if (!idExist){
            throw new BlogEntryNotFoundException(String.format("There is already a Blog Entry with ID = %d", id));
        }

        return blogEntryRepository.getBlogEntryById(id);
    }

    public List<BlogEntry> getAllBlogEntries(){
        return blogEntryRepository.getBlogEntries();
    }
}
