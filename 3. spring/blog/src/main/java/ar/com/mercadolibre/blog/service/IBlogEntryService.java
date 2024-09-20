package ar.com.mercadolibre.blog.service;

import ar.com.mercadolibre.blog.model.BlogEntry;
import ar.com.mercadolibre.blog.repository.BlogEntryRepository;

import java.util.List;

public interface IBlogEntryService {

    Integer saveBlogEntry(BlogEntry entry);

    BlogEntry getBlogEntryById(Integer id);

    List<BlogEntry> getAllBlogEntries();
}
