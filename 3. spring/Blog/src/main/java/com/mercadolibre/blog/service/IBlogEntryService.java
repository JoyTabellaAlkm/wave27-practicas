package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.model.BlogEntry;

import java.util.Set;

public interface IBlogEntryService {

    String CreateBlogEntry(BlogEntryDTO blogEntryDTO);

    BlogEntryDTO getBlogEntry(int id);

    Set<BlogEntryDTO> getBlogEntrys();

}
